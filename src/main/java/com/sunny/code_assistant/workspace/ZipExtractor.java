package com.sunny.code_assistant.workspace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ZipExtractor {
	
    public Path extract(MultipartFile zipFile)
            throws IOException {

        Path workspace = Files.createTempDirectory("workspace");

        // Extract zip into workspace

        return workspace;
    }
	
}
