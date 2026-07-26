package com.sunny.code_assistant.model;

import java.util.List;

public record IndexedClass(
    String packageName,
    String className,
    String filePath,
    List<String> methods,
    List<String> fields,
    List<String> annotations
	) {

}
