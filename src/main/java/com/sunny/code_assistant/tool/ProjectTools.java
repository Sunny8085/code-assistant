package com.sunny.code_assistant.tool;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import com.sunny.code_assistant.model.IndexedClass;
import com.sunny.code_assistant.model.ProjectIndex;
import com.sunny.code_assistant.model.ProjectRelation;
import com.sunny.code_assistant.scanner.ProjectScanner;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProjectTools {
	
//	private final ProjectScanner scanner;
	private final ProjectIndex index;
	
	//to call tool passed in the prompt, as mentation on description
	@Tool(description="List of all controller classes")
	public List<String> listControllers(){
	  return index.getClasses().stream()
	          .filter(c ->c.className().endsWith("Controller"))
	          .map(IndexedClass::className)
	          .toList();
	}
	
	@Tool(description="Search all list of classes")
	public IndexedClass searchClass(String className){
		return index.getClasses().stream()
				.filter(c ->c.className().equalsIgnoreCase(className))
	             .findFirst().orElse(null);
	}
	
	@Tool(description="Find class dependencies")
	public List<ProjectRelation> dependencies(String className){
	    return index.getRelations().stream()
	            .filter(r->r.source().equals(className)).toList();
	}
	
	@Tool(description="Find usages")
	public List<ProjectRelation> usages(String className){
	    return index.getRelations().stream()
	            .filter(r->r.target().equals(className)).toList();
	}
	
//	@Tool(description = "Returns all controller classes")
//	public List<String> listControllers() throws IOException {
//	    return scanner.scanJavaFiles("src/main/java").stream()
//	            .filter(path -> path.getFileName().toString().endsWith("Controller.java"))
//	            .map(path -> path.getFileName().toString()).toList();
//	}
//   
//   @Tool(description = "Search class by name")
//   public String searchClass(String className)throws IOException {
//       return scanner.scanJavaFiles("src/main/java").stream()
//               .filter(path -> path.getFileName().toString().equals(className + ".java"))
//               .findFirst().map(Path::toString).orElse("Class not found");
//   }
	
}
