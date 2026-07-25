package com.sunny.code_assistant.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.code_assistant.dto.CodeExplainRequest;
import com.sunny.code_assistant.dto.CodeExplainResponse;
import com.sunny.code_assistant.dto.RestApiResponse;
import com.sunny.code_assistant.service.CodeExplainService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/code")
@AllArgsConstructor
public class CodeExplainController {
	
	private final CodeExplainService chatExpService;
	
	@PostMapping("/explain")
	public ResponseEntity<RestApiResponse> explainCode(@Valid @RequestBody CodeExplainRequest request) {
		Optional<CodeExplainResponse> response = Optional.empty();
		try {
			response = Optional.ofNullable(chatExpService.explain(request.code()));
		} catch (Exception e) {
			throw new RuntimeException("Invalid response received from AI.");
		}
		return new ResponseEntity<>(new RestApiResponse(true , response), HttpStatus.OK);
	}
	
}







