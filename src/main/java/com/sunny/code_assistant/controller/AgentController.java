package com.sunny.code_assistant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.code_assistant.agent.AgentRequest;
import com.sunny.code_assistant.agent.AgentService;
import com.sunny.code_assistant.dto.RestApiResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/agent")
@RequiredArgsConstructor
public class AgentController {

    private final AgentService service;

    @PostMapping
    public ResponseEntity<RestApiResponse> execute(@RequestBody AgentRequest request)throws Exception {
        return new ResponseEntity<>(new RestApiResponse(true, service.execute(request.task())), HttpStatus.OK);
    }

}
