package com.sunny.code_assistant.service;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.ai.AIService;
import com.sunny.code_assistant.model.IndexedClass;
import com.sunny.code_assistant.prompt.PromptTemplates;
import com.sunny.code_assistant.tool.ProjectTools;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CodeModificationService {

    private final ProjectTools projectTools;
    private final AIService aiService;

    public String modify(String className, String instruction) throws Exception {

        IndexedClass clazz = projectTools.searchClass(className);
        if (clazz == null) {
            return "Class not found.";
        }
        String source = projectTools.readFile(clazz.filePath());
        String prompt = """
		%s
		Instruction:
		%s
		Java File:
		%s
		""".formatted(instruction, source);
        return aiService.chat(PromptTemplates.CODE_MODIFICATION, prompt);

    }

}
