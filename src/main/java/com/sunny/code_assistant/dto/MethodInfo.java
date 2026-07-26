package com.sunny.code_assistant.dto;

import java.util.List;

public record MethodInfo(String name, String returnType, List<String> parameters, List<String> annotations ) {

}
