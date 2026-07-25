package com.sunny.code_assistant.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AIService {

    private final ChatClient chatClient;
    private final ObjectMapper objectMapper;
    
	/**
	 * system() - Sets the AI's role, rules, and context that guide how it responds.
	 * user() - Supplies the user's input that the AI should answer.
	 */
    public String chat(String systemPrompt, String userPrompt) {
		return chatClient.prompt()
		     .system(systemPrompt)
		     .user(userPrompt)
		     .call()
		     .content();
	}
	
	public <T> T chat(String systemPrompt, String userPrompt, Class<T> responseType){
		try{
			String response = chat(systemPrompt, userPrompt);
			return objectMapper.readValue(response, responseType);
			}catch (JsonProcessingException e) {
				throw new RuntimeException("Invalid response received from AI.");
			}
			catch (Exception e) {
				throw new RuntimeException("Unable to analyze code.");
			}
	}
	
}






