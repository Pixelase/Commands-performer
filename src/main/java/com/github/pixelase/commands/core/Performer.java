package com.github.pixelase.commands.core;

public interface Performer {
	void perform(String commandName, String... args);

	boolean tryPerform(String commandName, String... args);
}
