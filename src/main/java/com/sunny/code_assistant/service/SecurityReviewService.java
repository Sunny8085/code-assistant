package com.sunny.code_assistant.service;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.ai.AIService;
import com.sunny.code_assistant.prompt.PromptTemplates;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecurityReviewService {

    private final AIService aiService;

    public String review(String code) {
        return aiService.chat(PromptTemplates.SECURITY_REVIEW, code);
    }

}
