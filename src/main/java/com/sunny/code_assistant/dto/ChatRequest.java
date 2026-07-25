package com.sunny.code_assistant.dto;

import jakarta.validation.constraints.NotBlank;

public record ChatRequest(
		@NotBlank(message = "Message cannot be empty")String message) {
}
