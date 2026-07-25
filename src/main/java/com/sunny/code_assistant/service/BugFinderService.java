package com.sunny.code_assistant.service;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.ai.AIService;
import com.sunny.code_assistant.dto.BugFinderResponse;
import com.sunny.code_assistant.prompt.PromptTemplates;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BugFinderService {
	
	private final AIService aiService;
    
    public BugFinderResponse analyze(String code) {
	    return aiService.chat(PromptTemplates.BUG_FINDER, code, BugFinderResponse.class);
    }
	
}
