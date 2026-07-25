package com.sunny.code_assistant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.code_assistant.dto.JUnitRequest;
import com.sunny.code_assistant.dto.JUnitResponse;
import com.sunny.code_assistant.dto.RestApiResponse;
import com.sunny.code_assistant.service.JUnitGeneratorService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/junit")
@AllArgsConstructor
public class JUnitController{
	
	private final JUnitGeneratorService junitGeneratorService;
	
	@PostMapping("/generate")
	public ResponseEntity<RestApiResponse> generateJUnitTests(@Valid @RequestBody JUnitRequest request) {
		JUnitResponse response = junitGeneratorService.execute(request.code());
		return new ResponseEntity<>(new RestApiResponse(true, response), HttpStatus.OK);
	}
	
}
