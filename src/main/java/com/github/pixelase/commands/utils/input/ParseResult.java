package com.github.pixelase.commands.utils.input;

public class ParseResult {
	private final String commandName;
	private final String[] args;

	public ParseResult() {
		this("", new String[0]);
	}

	public ParseResult(String commandName, String[] args) {
		super();
		this.commandName = commandName;
		this.args = args;
	}

	public String getCommandName() {
		return commandName;
	}

	public String[] getArgs() {
		return args;
	}

}
