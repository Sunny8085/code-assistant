package com.sunny.code_assistant.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProjectIndex {

    private final List<IndexedClass> classes = new ArrayList<>();
    
    private final List<ProjectRelation> relations = new ArrayList<>();

    public void clear() {
        classes.clear();
    }

    public void add(IndexedClass clazz) {
        classes.add(clazz);
    }

    public List<IndexedClass> getClasses() {
        return classes;
    }
    
    public void addRelation(ProjectRelation relation) {
		relations.add(relation);
	}
    
    public List<ProjectRelation> getRelations() {
		return relations;
	}
    
}
