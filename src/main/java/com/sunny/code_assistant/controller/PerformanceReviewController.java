package com.sunny.code_assistant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.code_assistant.dto.PerformanceReviewRequest;
import com.sunny.code_assistant.dto.RestApiResponse;
import com.sunny.code_assistant.service.PerformanceReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/performance")
@RequiredArgsConstructor
public class PerformanceReviewController {

    private final PerformanceReviewService service;

    @PostMapping("/review")
    public ResponseEntity<RestApiResponse> review(@RequestBody PerformanceReviewRequest request) {
        return new ResponseEntity<>(new RestApiResponse(true, service.review(request.code())), HttpStatus.OK);
    }

}
