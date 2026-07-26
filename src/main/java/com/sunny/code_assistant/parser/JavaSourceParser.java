package com.sunny.code_assistant.parser;

import java.util.List;

import org.springframework.stereotype.Component;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ParserConfiguration.LanguageLevel;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.sunny.code_assistant.dto.FieldInfo;
import com.sunny.code_assistant.dto.JavaFileInfo;
import com.sunny.code_assistant.dto.MethodInfo;

@Component
public class JavaSourceParser {
	
	private final JavaParser javaParser;
	
	public JavaSourceParser() {
		ParserConfiguration config = new ParserConfiguration();
		config.setLanguageLevel(LanguageLevel.JAVA_21);
		this.javaParser = new JavaParser(config);
	}
	
    public JavaFileInfo parse(String source) {
        var cu = javaParser.parse(source).getResult().orElseThrow(() ->
            new IllegalArgumentException("Failed to parse source code"));

        String packageName = cu.getPackageDeclaration()
                .map(pd -> pd.getNameAsString()).orElse("");

        List<String> imports = cu.getImports().stream()
                .map(i -> i.getNameAsString()).toList();

        var clazz = cu.getType(0);

        String className = clazz.getNameAsString();

        List<FieldInfo> fields = clazz.findAll(FieldDeclaration.class).stream()
                .map(field -> new FieldInfo(field.getElementType().asString(), field.getVariables().get(0).getNameAsString(),
                        field.getAnnotations().stream()
                                .map(a -> a.getNameAsString()).toList(),
                        field.getModifiers().stream()
                                .map(m -> m.getKeyword().asString()).toList()
                )).toList();

        List<MethodInfo> methods = clazz.findAll(MethodDeclaration.class).stream()
                .map(method -> new MethodInfo(method.getNameAsString(), method.getType().asString(),
                        method.getParameters().stream()
                                .map(p -> p.getType().asString() + " " + p.getNameAsString()).toList(),
                        method.getAnnotations().stream()
                                .map(a -> a.getNameAsString()).toList()
                ))
                .toList();
        
        return new JavaFileInfo(packageName, className, methods, fields, imports);
    }

	
}
