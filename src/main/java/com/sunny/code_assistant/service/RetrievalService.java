package com.sunny.code_assistant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.model.IndexedClass;
import com.sunny.code_assistant.model.ProjectIndex;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrievalService {

    private final ProjectIndex index;

    public List<IndexedClass> retrieve(String question) {
        String lower = question.toLowerCase();
        return index.getClasses().stream()
        				.filter(c -> c.className().toLowerCase().contains(lower)).toList();
    }
    
}
