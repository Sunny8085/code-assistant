package com.sunny.code_assistant.index;

import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Service;

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
        List<Path> files = scanner.scanJavaFiles(root);
        for (Path path : files) {
            String source = scanner.readFile(path);
            JavaFileInfo info = parser.parse(source);
            IndexedClass clazz = new IndexedClass(
                    info.packageName(), info.className(), path.toString(), info.methods(), info.fields(),
                    List.of()
            );
            index.add(clazz);
            
            //Add Class Relation Ship Logic 
            for (String field : info.fields()) {
                if (field.contains("Service")) {
                    index.addRelation(new ProjectRelation(info.className(), info.className(), "USES"));
                }
            }
        }
    }
    
}
