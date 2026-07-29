package com.sunny.code_assistant.service;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmbeddingService {

    private final EmbeddingModel embeddingModel;

    public float[] embed(String text) {
        if (embeddingModel == null) {
            throw new IllegalStateException("No EmbeddingModel configured. Please configure Spring AI embeddings provider.");
        }
        return embeddingModel.embed(text);
    }

}