package com.sunny.code_assistant.review;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.ai.AIService;
import com.sunny.code_assistant.prompt.PromptTemplates;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodeReviewService {
	
    private final AIService aiService;

    public String review(String javaCode) {
        return aiService.chat(PromptTemplates.CODE_REVIEW, javaCode);
    }
	
}
