package com.sunny.code_assistant.parser;

import java.util.List;

import org.springframework.stereotype.Component;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ParserConfiguration.LanguageLevel;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.sunny.code_assistant.dto.JavaFileInfo;

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

        List<String> methods = clazz.findAll(MethodDeclaration.class).stream()
                .map(MethodDeclaration::getDeclarationAsString).toList();

        List<String> fields = clazz.findAll(FieldDeclaration.class).stream()
                .map(FieldDeclaration::toString).toList();

        return new JavaFileInfo(packageName, className, methods, fields, imports);
    }

	
}
