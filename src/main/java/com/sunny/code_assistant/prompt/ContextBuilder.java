package com.sunny.code_assistant.prompt;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sunny.code_assistant.model.IndexedClass;

@Component
public class ContextBuilder {

    public String build(List<IndexedClass> classes) {
        StringBuilder builder = new StringBuilder();
        for (IndexedClass clazz : classes) {
            builder.append("Class: ").append(clazz.className()).append("\n");
            builder.append("Methods:\n");
            clazz.methods().forEach(builder::append);
            builder.append("\n");
        }
        return builder.toString();
    }

}
