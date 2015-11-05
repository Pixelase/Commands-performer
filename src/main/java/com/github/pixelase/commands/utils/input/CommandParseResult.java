package com.github.pixelase.commands.utils.input;

import java.util.Arrays;

public class CommandParseResult {
	private final String commandName;
	private final String[] args;

	public CommandParseResult() {
		this("", new String[0]);
	}

	public CommandParseResult(String commandName, String... args) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(args);
		result = prime * result + ((commandName == null) ? 0 : commandName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandParseResult other = (CommandParseResult) obj;
		if (!Arrays.equals(args, other.args))
			return false;
		if (commandName == null) {
			if (other.commandName != null)
				return false;
		} else if (!commandName.equals(other.commandName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommandParseResult [commandName=" + commandName + ", args=" + Arrays.toString(args) + "]";
	}
}
