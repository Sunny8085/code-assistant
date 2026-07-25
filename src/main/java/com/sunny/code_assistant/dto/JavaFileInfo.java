package com.sunny.code_assistant.dto;

import java.util.List;

public record JavaFileInfo(
       String packageName,
       String className,
       List<String> methods,
       List<String> fields,
       List<String> imports
	) {
}
