package com.sunny.code_assistant.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sunny.code_assistant.dto.JavaFileInfo;
import com.sunny.code_assistant.parser.JavaSourceParser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FileUploadService {

	private final JavaSourceParser parser;
	
    public JavaFileInfo parse(MultipartFile file) throws IOException {
        String source = new String(file.getBytes());
        return parser.parse(source);

    }
    
    
}
