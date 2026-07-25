package com.sunny.code_assistant.dto;

import java.util.List;

public record ClassAnalysisResponse(
    String className,
    String purpose,
    List<String> responsibilities,
    List<String> publicMethods,
    List<String> dependencies,
    List<String> designPatterns,
    List<String> codeSmells,
    List<String> improvements
	) {

}
