package com.sunny.code_assistant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.code_assistant.dto.BugFinderRequest;
import com.sunny.code_assistant.dto.BugFinderResponse;
import com.sunny.code_assistant.dto.RestApiResponse;
import com.sunny.code_assistant.service.BugFinderService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/bug")
@AllArgsConstructor
public class BugFinderController {
	
	private final BugFinderService bugFinderService;
	
	@PostMapping("/finder")
	public ResponseEntity<RestApiResponse> findBugs(@Valid @RequestBody BugFinderRequest request) {
		BugFinderResponse response = bugFinderService.analyze(request.code());
		return new ResponseEntity<>(new RestApiResponse(true, response), HttpStatus.OK);
	}
	
}



