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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((args == null) ? 0 : args.hashCode());
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
		if (args == null) {
			if (other.args != null)
				return false;
		} else if (!args.equals(other.args))
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
		return "CommandParseResult [commandName=" + commandName + ", args=" + args + "]";
	}
}
