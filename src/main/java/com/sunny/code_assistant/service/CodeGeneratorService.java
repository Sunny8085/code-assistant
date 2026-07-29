package com.sunny.code_assistant.service;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.ai.AIService;
import com.sunny.code_assistant.prompt.PromptTemplates;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodeGeneratorService {

    private final AIService aiService;

    public String generate(String request) {
        return aiService.chat(PromptTemplates.SPRING_BOOT_GENERATOR, request);
    }

}
