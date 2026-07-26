package com.sunny.code_assistant.dto;

import java.util.List;

public record JavaFileInfo(
       String packageName,
       String className,
       List<MethodInfo> methods,
       List<FieldInfo> fields,
       List<String> imports
	) {
}
