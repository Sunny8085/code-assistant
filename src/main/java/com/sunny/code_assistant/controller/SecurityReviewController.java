package com.sunny.code_assistant.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.code_assistant.dto.SecurityReviewRequest;
import com.sunny.code_assistant.service.SecurityReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/security")
@RequiredArgsConstructor
public class SecurityReviewController {

    private final SecurityReviewService service;

    @PostMapping("/review")
    public String review(
            @RequestBody SecurityReviewRequest request) {

        return service.review(request.code());

    }

}
