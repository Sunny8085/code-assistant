package com.sunny.code_assistant.dto;

import java.util.List;

public record FieldInfo(String type, String name, List<String> annotations, List<String> modifiers) {

}
