package com.sunny.code_assistant.dto;

import jakarta.validation.constraints.NotBlank;

public record JavaDocRequest(@NotBlank String code) {

}
