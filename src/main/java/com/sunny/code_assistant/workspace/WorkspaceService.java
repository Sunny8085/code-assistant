package com.sunny.code_assistant.workspace;

import java.nio.file.Path;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sunny.code_assistant.index.ProjectIndexer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkspaceService {
	
    private final ZipExtractor extractor;
    private final ProjectIndexer indexer;
    
    public void loadWorkspace(MultipartFile file) throws Exception {
        Path workspace = extractor.extract(file);
        indexer.indexProject(workspace.resolve("src/main/java").toString());
    }
	
}
