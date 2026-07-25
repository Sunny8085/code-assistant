package com.sunny.code_assistant.service;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.ai.AIService;
import com.sunny.code_assistant.dto.CodeExplainResponse;
import com.sunny.code_assistant.prompt.PromptTemplates;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CodeExplainService {
	
	private final AIService aiService;
	
    public CodeExplainResponse explain(String code) throws Exception {
    		return aiService.chat(PromptTemplates.CODE_EXPLAINER, code, CodeExplainResponse.class);
    }
	
    
	
}








