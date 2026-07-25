package com.sunny.code_assistant.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sunny.code_assistant.tool.ProjectTools;

@Configuration
public class AIConfig {
	
	/**
	 * @param tools the tool provider containing AI tool methods that are registered
	 * with the {@link ChatClient} for automatic invocation by the model.
	 */
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, ProjectTools tools) {
        return builder.defaultTools(tools).build();
    }
	
}
