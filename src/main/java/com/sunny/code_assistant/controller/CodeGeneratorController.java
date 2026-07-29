package com.sunny.code_assistant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.code_assistant.dto.CodeGenerationRequest;
import com.sunny.code_assistant.dto.RestApiResponse;
import com.sunny.code_assistant.service.CodeGeneratorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/generator")
@RequiredArgsConstructor
public class CodeGeneratorController {

    private final CodeGeneratorService service;

    @PostMapping
    public ResponseEntity<RestApiResponse> generate(@RequestBody CodeGenerationRequest request) {
    		return new ResponseEntity<>(new RestApiResponse(true, service.generate(request.request())), HttpStatus.OK);
    }

}
