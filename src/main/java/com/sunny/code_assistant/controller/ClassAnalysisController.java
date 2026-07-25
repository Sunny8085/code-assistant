package com.sunny.code_assistant.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sunny.code_assistant.dto.ClassAnalysisResponse;
import com.sunny.code_assistant.dto.JavaFileInfo;
import com.sunny.code_assistant.service.ClassAnalysisService;
import com.sunny.code_assistant.service.FileUploadService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/class")
public class ClassAnalysisController {
	
    private final FileUploadService uploadService;
    private final ClassAnalysisService classAnalysisService;
	
    @PostMapping("/analyze")
    public ClassAnalysisResponse analyze(@RequestParam MultipartFile file) throws Exception{
        JavaFileInfo info = uploadService.parse(file);
        return classAnalysisService.analyze(info);
    }
	
}
