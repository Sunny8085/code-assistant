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
public class ChatService {
	
	private final AIService aiService;
	private final RetrievalService retrievalService;
	 private final ContextBuilder contextBuilder;
	
	public String chat(String message) {
//		return aiService.chat(PromptTemplates.JAVA_EXPERT, message);
		List<IndexedClass> classes = retrievalService.retrieve(message);
		String context = contextBuilder.build(classes);
		String prompt = """
		Use only this project information.
		%s
		Question:
		%s
		"""
		.formatted(context, message);
		return aiService.chat(PromptTemplates.JAVA_EXPERT, prompt);
	}
	
	
	
	
	
}














