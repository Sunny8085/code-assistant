package com.sunny.code_assistant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.code_assistant.dto.RestApiResponse;
import com.sunny.code_assistant.index.ProjectIndexer;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/project")
public class ProjectController {
	
	private final ProjectIndexer projectIndexer;
	
    @PostMapping("/index")
    public ResponseEntity<RestApiResponse> indexProject(@RequestParam String projectPath) throws Exception {
    		
        projectIndexer.indexProject(projectPath);

        return new ResponseEntity<>(new RestApiResponse(true, "Project indexed successfully"), HttpStatus.CREATED);
    }
	
}
