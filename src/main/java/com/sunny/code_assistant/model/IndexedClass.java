package com.sunny.code_assistant.model;

import java.util.List;

import com.sunny.code_assistant.dto.FieldInfo;
import com.sunny.code_assistant.dto.MethodInfo;

public record IndexedClass(
    String packageName,
    String className,
    String filePath,
    List<MethodInfo> methods,
    List<FieldInfo> fields,
    List<String> annotations,
    float[] embedding
	) {

}
