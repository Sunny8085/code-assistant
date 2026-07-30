package com.sunny.code_assistant.agent;

import org.springframework.stereotype.Component;

import com.sunny.code_assistant.model.IndexedClass;
import com.sunny.code_assistant.tool.ProjectTools;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AgentExecutor {

    private final ProjectTools projectTools;

    public String execute(String step, String target) throws Exception {

        return switch (step) {
            case "SEARCH_CLASS" -> {
                IndexedClass clazz = projectTools.searchClass(target);
                if (clazz == null) {
                    yield "Class not found.";
                }
                yield """
                    Class Found
                    Name: %s
                    Path: %s
                    """
                     .formatted(clazz.className(), clazz.filePath());
            }
            case "READ_FILE" -> {
                IndexedClass clazz = projectTools.searchClass(target);
                if (clazz == null) {
                    yield "Class not found.";
                }
                yield projectTools.readFile(clazz.filePath());
            }

            case "DEPENDENCIES" -> {
                var list = projectTools.dependencies(target);
                yield list.toString();
            }

            case "USAGES" -> {
                var list = projectTools.usages(target);
                yield list.toString();
            }

            case "LIST_CONTROLLERS" -> {
                yield projectTools.listControllers().toString();
            }
            default -> "Unknown step";
        };

    }

}
