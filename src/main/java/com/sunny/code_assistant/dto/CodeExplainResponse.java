package com.sunny.code_assistant.dto;

import java.util.List;

public record CodeExplainResponse(
		String purpose,
		String timeComplexity,
		String spaceComplexity,
		List<String> keyPoints
		) {
}
