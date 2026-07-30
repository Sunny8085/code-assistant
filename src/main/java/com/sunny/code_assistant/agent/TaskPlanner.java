package com.sunny.code_assistant.agent;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TaskPlanner {

    public List<AgentAction> plan(String task) {
        List<AgentAction> actions = new ArrayList<>();
        String lower = task.toLowerCase();
        if (lower.contains("employeecontroller")) {
            actions.add(new AgentAction("SEARCH_CLASS", "EmployeeController"));
            actions.add(new AgentAction("READ_FILE", "EmployeeController"));
        }

        if (lower.contains("employeeservice")) {
            actions.add(new AgentAction("SEARCH_CLASS", "EmployeeService"));
            actions.add(new AgentAction("READ_FILE", "EmployeeService"));
        }

        if (lower.contains("dependency")) {
            actions.add(new AgentAction("DEPENDENCIES", "EmployeeService"));
        }

        if (lower.contains("controller")) {
            actions.add(new AgentAction("LIST_CONTROLLERS",""));
        }
        return actions;
    }

}
