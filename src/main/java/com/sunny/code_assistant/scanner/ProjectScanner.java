package com.sunny.code_assistant.scanner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class ProjectScanner {

    public List<Path> scanJavaFiles(String root) throws IOException {
        try (var paths = Files.walk(Paths.get(root))) {
            return paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .collect(Collectors.toList());
        }
    }
    
    public String readFile(Path path) throws IOException {
        return Files.readString(path);
    }
    
}
