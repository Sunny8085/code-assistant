package com.sunny.code_assistant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.code_assistant.dto.ChatRequest;
import com.sunny.code_assistant.dto.ChatResponse;
import com.sunny.code_assistant.dto.RestApiResponse;
import com.sunny.code_assistant.service.ChatService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/chat")
@AllArgsConstructor
public class ChatController {
	
	private final ChatService chatService;
	
	@PostMapping("/")
	public ResponseEntity<RestApiResponse> chat(@Valid @RequestBody ChatRequest request) {
		String response = chatService.chat(request.message());
		return new ResponseEntity<>(new RestApiResponse(true, new ChatResponse(response)), HttpStatus.OK);
	}

	
}










