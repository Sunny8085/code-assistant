package com.sunny.code_assistant.model;

public record EmbeddingDocument(
        String id,
        String className,
        String content,
        float[] embedding
) {
}
