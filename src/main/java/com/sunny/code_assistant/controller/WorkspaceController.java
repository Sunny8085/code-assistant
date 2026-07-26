package com.sunny.code_assistant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sunny.code_assistant.dto.RestApiResponse;
import com.sunny.code_assistant.workspace.WorkspaceService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/workspace")
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    @PostMapping("/upload")
    public ResponseEntity<RestApiResponse> upload(@RequestParam MultipartFile file) throws Exception {
        workspaceService.loadWorkspace(file);
        return new ResponseEntity<>(new RestApiResponse(true, "Workspace indexed successfully."), HttpStatus.CREATED);
    }

}
