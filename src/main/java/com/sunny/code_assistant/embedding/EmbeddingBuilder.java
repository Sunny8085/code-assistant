package com.sunny.code_assistant.embedding;

import org.springframework.stereotype.Component;

import com.sunny.code_assistant.dto.JavaFileInfo;

@Component
public class EmbeddingBuilder {

    public String build(JavaFileInfo clazz) {

        StringBuilder builder = new StringBuilder();

        builder.append("Package: ").append(clazz.packageName()).append("\n\n");

        builder.append("Class: ").append(clazz.className()).append("\n\n");

        builder.append("Methods:\n");

        clazz.methods().forEach(method -> builder.append(method.name()).append("\n"));

        builder.append("\nFields:\n");

        clazz.fields().forEach(field -> builder.append(field.type()).append(" ").append(field.name()).append("\n"));

        return builder.toString();
    }
}
