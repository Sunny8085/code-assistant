package com.sunny.code_assistant.ai;

public interface AIFeature<I, O> {
	O execute(I input);
}
