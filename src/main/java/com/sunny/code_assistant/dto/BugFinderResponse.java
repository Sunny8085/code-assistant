package com.sunny.code_assistant.dto;

import java.util.List;

public record BugFinderResponse(
        boolean hasBug,
        String bug,
        String reason,
        String fixedCode,
        List<String> bestPractices
) {
}
