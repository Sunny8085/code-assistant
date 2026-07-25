package com.sunny.code_assistant.service;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.ai.AIService;
import com.sunny.code_assistant.prompt.PromptTemplates;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ChatService {
	
	private final AIService aiService;
	
	public String chat(String message) {
		return aiService.chat(PromptTemplates.JAVA_EXPERT, message);
	}
	
	
	
	
	
}














