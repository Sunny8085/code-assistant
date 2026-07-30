package com.sunny.code_assistant.agent;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TaskPlanner {

    public List<String> plan(String task) {
        List<String> steps = new ArrayList<>();
        String lower = task.toLowerCase();
        if (lower.contains("controller")) {
            steps.add("SEARCH_CLASS");
            steps.add("READ_FILE");
        }
        if (lower.contains("service")) {
            steps.add("SEARCH_CLASS");
            steps.add("READ_FILE");
        }
        if (lower.contains("dependency")) {
            steps.add("FIND_DEPENDENCIES");
        }
        if (steps.isEmpty()) {
            steps.add("CHAT");
        }
        return steps;
    }
}
