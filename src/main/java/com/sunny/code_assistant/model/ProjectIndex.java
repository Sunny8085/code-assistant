package com.sunny.code_assistant.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProjectIndex {

    private final List<IndexedClass> classes = new ArrayList<>();

    public void clear() {
        classes.clear();
    }

    public void add(IndexedClass clazz) {
        classes.add(clazz);
    }

    public List<IndexedClass> getClasses() {
        return classes;
    }

}
