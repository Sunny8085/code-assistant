package com.sunny.code_assistant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.code_assistant.dto.ProjectAnalysisRequest;
import com.sunny.code_assistant.dto.RestApiResponse;
import com.sunny.code_assistant.service.ProjectAnalysisService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
public class ProjectAnalysisController {

    private final ProjectAnalysisService service;

    @PostMapping("/analyze")
    public ResponseEntity<RestApiResponse> analyze(@RequestBody ProjectAnalysisRequest request) {
        return new ResponseEntity<>(new RestApiResponse(true, service.analyze(request.question())), HttpStatus.OK);
    }

}