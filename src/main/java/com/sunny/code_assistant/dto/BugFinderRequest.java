package com.sunny.code_assistant.dto;

import jakarta.validation.constraints.NotBlank;

public record BugFinderRequest(@NotBlank String code) {

}
