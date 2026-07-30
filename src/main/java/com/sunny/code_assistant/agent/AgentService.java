package com.sunny.code_assistant.agent;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.code_assistant.ai.AIService;
import com.sunny.code_assistant.prompt.PromptTemplates;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final TaskPlanner planner;
    private final AIService aiService;

    public String execute(String task) throws Exception {
        List<String> steps = planner.plan(task);
        StringBuilder userPrompt = new StringBuilder();

        userPrompt.append("User Task:\n").append(task).append("\n\n");
        userPrompt.append("Execution Plan:\n");

        for (String step : steps) {
            userPrompt.append("- ").append(step).append("\n");
        }

        return aiService.chat(PromptTemplates.AGENT_SYSTEM_PROMPT,userPrompt.toString());

    }

}
