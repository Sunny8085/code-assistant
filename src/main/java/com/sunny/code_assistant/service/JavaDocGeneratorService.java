package com.sunny.code_assistant.service;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.ai.AIFeature;
import com.sunny.code_assistant.ai.AIService;
import com.sunny.code_assistant.dto.JavaDocResponse;
import com.sunny.code_assistant.prompt.PromptTemplates;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JavaDocGeneratorService implements AIFeature<String, JavaDocResponse> {
	
	private final AIService aiService;

	@Override
	public JavaDocResponse execute(String input) {
		return aiService.chat(PromptTemplates.JAVADOC_GENERATOR, input, JavaDocResponse.class);
	}
	

	
}








