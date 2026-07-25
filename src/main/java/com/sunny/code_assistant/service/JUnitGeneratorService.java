package com.sunny.code_assistant.service;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.ai.AIFeature;
import com.sunny.code_assistant.ai.AIService;
import com.sunny.code_assistant.dto.JUnitResponse;
import com.sunny.code_assistant.prompt.PromptTemplates;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JUnitGeneratorService implements AIFeature<String, JUnitResponse>{
	
	private final AIService aiService;

	@Override
	public JUnitResponse execute(String code) {
		return aiService.chat(PromptTemplates.JUNIT_GENERATOR, code, JUnitResponse.class);
	}
	
}







