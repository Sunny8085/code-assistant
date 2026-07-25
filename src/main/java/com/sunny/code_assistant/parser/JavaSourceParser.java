package com.sunny.code_assistant.parser;

import java.util.List;

import org.springframework.stereotype.Component;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.sunny.code_assistant.dto.JavaFileInfo;

@Component
public class JavaSourceParser {
	
    public JavaFileInfo parse(String source) {
        var cu = StaticJavaParser.parse(source);

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
