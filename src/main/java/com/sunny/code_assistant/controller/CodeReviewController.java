package com.sunny.code_assistant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.code_assistant.dto.CodeReviewRequest;
import com.sunny.code_assistant.dto.RestApiResponse;
import com.sunny.code_assistant.review.CodeReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor
public class CodeReviewController {

    private final CodeReviewService service;

    @PostMapping
    public ResponseEntity<RestApiResponse> review(@RequestBody CodeReviewRequest request) {
    		return new ResponseEntity<>(new RestApiResponse(true, service.review(request.code())), HttpStatus.OK);
    }

}
