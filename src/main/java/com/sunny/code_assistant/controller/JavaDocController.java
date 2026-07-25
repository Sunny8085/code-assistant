package com.sunny.code_assistant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.code_assistant.dto.JavaDocRequest;
import com.sunny.code_assistant.dto.JavaDocResponse;
import com.sunny.code_assistant.dto.RestApiResponse;
import com.sunny.code_assistant.service.JavaDocGeneratorService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/javadoc")
@AllArgsConstructor
public class JavaDocController {
	
	private final JavaDocGeneratorService javaDocService;
	
	@PostMapping("/generate")
	public ResponseEntity<RestApiResponse> generateJavaDoc(@Valid @RequestBody JavaDocRequest request) {
		JavaDocResponse response = javaDocService.execute(request.code());
		return new ResponseEntity<>(new RestApiResponse(true, response), HttpStatus.OK);
	}
	
}
