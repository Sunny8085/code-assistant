package com.sunny.code_assistant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sunny.code_assistant.dto.RestApiResponse;
import com.sunny.code_assistant.service.FileUploadService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/upload")
public class UploadController {
	
	private final FileUploadService service;
	
	@PostMapping("/java")
    public ResponseEntity<RestApiResponse> upload(@RequestParam MultipartFile file)throws Exception {
		if (!file.getOriginalFilename().endsWith(".java")) {
		    throw new IllegalArgumentException("Only .java files are supported.");
		}
        return new ResponseEntity<>(new RestApiResponse(true, service.parse(file)), HttpStatus.OK);
    }
	
}
