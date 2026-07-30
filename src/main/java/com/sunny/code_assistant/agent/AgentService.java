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
    private final AgentExecutor executor;
    private final AIService aiService;

    public String execute(String task) throws Exception {
        List<AgentAction> actions = planner.plan(task);
        StringBuilder context = new StringBuilder();
        for (AgentAction action : actions) {
            String result = executor.execute(action.step(), action.target());
            context.append("""
                    Step:
                    %s
                    Result:
                    %s
                    ===================
                    """
                    .formatted(action.step(),result));
        }

        return aiService.chat(PromptTemplates.AGENT_SYSTEM_PROMPT, context.toString());
    }

}