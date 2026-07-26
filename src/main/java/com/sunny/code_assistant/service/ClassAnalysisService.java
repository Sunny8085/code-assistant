package com.sunny.code_assistant.service;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.ai.AIService;
import com.sunny.code_assistant.dto.ClassAnalysisResponse;
import com.sunny.code_assistant.dto.JavaFileInfo;
import com.sunny.code_assistant.prompt.PromptTemplates;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassAnalysisService {
	
	private final AIService aiService;
	
    public ClassAnalysisResponse analyze(JavaFileInfo info) throws Exception {
        String prompt = buildPrompt(info);
        return aiService.chat(PromptTemplates.CLASS_ANALYZER,prompt,ClassAnalysisResponse.class);
    }
	
    private String buildPrompt(JavaFileInfo info){
        return """
	    Package:
	    %s
	    Class:
	    %s
	    Methods:
	    %s
	    Fields:
	    %s
	    Imports:
	    %s
	    """
	    .formatted(
	    info.packageName(),
	    info.className(),
	    info.methods(),
	    info.fields(),
	    String.join("\n",info.imports())
	    );
    }
    
}
