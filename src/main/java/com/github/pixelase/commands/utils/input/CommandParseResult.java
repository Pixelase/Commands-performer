package com.github.pixelase.commands.utils.input;

import java.util.ArrayList;
import java.util.List;

public class CommandParseResult {
	private final String commandName;
	private final List<String> args;

	public CommandParseResult() {
		this("", new ArrayList<String>());
	}

	public CommandParseResult(String commandName, List<String> args) {
		super();
		this.commandName = commandName;
		this.args = args;
	}

	public String getCommandName() {
		return commandName;
	}

	public List<String> getArgs() {
		return args;
	}
}
