package com.sunny.code_assistant.service;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.ai.AIService;
import com.sunny.code_assistant.prompt.PromptTemplates;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PerformanceReviewService {

    private final AIService aiService;

    public String review(String code) {
        return aiService.chat(PromptTemplates.PERFORMANCE_REVIEW, code);
    }

}
