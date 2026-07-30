package com.sunny.code_assistant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.ai.AIService;
import com.sunny.code_assistant.model.IndexedClass;
import com.sunny.code_assistant.prompt.ContextBuilder;
import com.sunny.code_assistant.prompt.PromptTemplates;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectAnalysisService {
	
    private final RetrievalService retrievalService;
    private final ContextBuilder contextBuilder;
    private final AIService aiService;
    
    public String analyze(String question) {

        List<IndexedClass> classes = retrievalService.retrieve(question);
        String context = contextBuilder.build(classes);
        String prompt = """
		%s
		Project Context:
		%s
		Question:
		%s
		"""
		.formatted(context, question );
        return aiService.chat(PromptTemplates.PROJECT_ANALYSIS, prompt);

    }
	
}
