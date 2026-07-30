package com.sunny.code_assistant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.code_assistant.dto.CodeModificationRequest;
import com.sunny.code_assistant.dto.RestApiResponse;
import com.sunny.code_assistant.service.CodeModificationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/modify")
@RequiredArgsConstructor
public class CodeModificationController {

    private final CodeModificationService service;

    @PostMapping
    public ResponseEntity<RestApiResponse> modify(@Valid @RequestBody CodeModificationRequest request)throws Exception {
        return new ResponseEntity<>(new RestApiResponse(true, 
        		service.modify(request.className(), request.instruction())), HttpStatus.OK);
    }

}
