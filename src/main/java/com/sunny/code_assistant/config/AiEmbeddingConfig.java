package com.sunny.code_assistant.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.embedding.EmbeddingModel;

/**
 * Provides a fallback EmbeddingModel bean when no embedding provider is auto-configured.
 *
 * This avoids a hard application startup failure (UnsatisfiedDependencyException)
 * and returns a clear runtime error if embeddings are actually invoked without a
 * configured provider.
 */
@Configuration
public class AiEmbeddingConfig {

    @Bean
    @ConditionalOnMissingBean(EmbeddingModel.class)
    public EmbeddingModel fallbackEmbeddingModel() {
        return (EmbeddingModel) java.lang.reflect.Proxy.newProxyInstance(EmbeddingModel.class.getClassLoader(),
            new Class[] { EmbeddingModel.class },
            (proxy, method, args) -> {
                throw new IllegalStateException(
                        "No EmbeddingModel configured. Please configure a Spring AI embeddings provider (e.g. Google GenAI) and provide credentials.");
            });
    }

}
