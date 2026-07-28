package com.sunny.code_assistant.index;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.dto.FieldInfo;
import com.sunny.code_assistant.dto.JavaFileInfo;
import com.sunny.code_assistant.model.IndexedClass;
import com.sunny.code_assistant.model.ProjectIndex;
import com.sunny.code_assistant.model.ProjectRelation;
import com.sunny.code_assistant.parser.JavaSourceParser;
import com.sunny.code_assistant.scanner.ProjectScanner;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectIndexer {

    private final ProjectScanner scanner;
    private final JavaSourceParser parser;
    private final ProjectIndex index;
    
    public void indexProject(String root) throws Exception {
        index.clear();
        
        // Validate root directory exists
        Path rootPath = Path.of(root);
        if (!Files.exists(rootPath))
            throw new RuntimeException("Root directory not found: " + root);
        if (!Files.isDirectory(rootPath))
            throw new IllegalArgumentException("Root path is not a directory: " + root);
        
        List<Path> files = scanner.scanJavaFiles(root);
        for (Path path : files) {
            String source = scanner.readFile(path);
            JavaFileInfo info = parser.parse(source);
            if(info == null)
            		continue;
            IndexedClass clazz = new IndexedClass(
                    info.packageName(), info.className(), path.toString(), info.methods(), info.fields(),
                    List.of()
            );
            index.add(clazz);
            
            //Add Class Relationship Logic
            for (FieldInfo field : info.fields()) {
                if (field.type().endsWith("Service")) {
                    index.addRelation(new ProjectRelation(info.className(), field.type(), "USES"));
                }
            }
        }
    }
    
}
