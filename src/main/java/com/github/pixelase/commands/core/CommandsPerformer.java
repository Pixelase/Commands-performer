package com.github.pixelase.commands.core;

import java.util.List;

public class CommandsPerformer implements Performer {
	protected List<Command> commands;

	public CommandsPerformer(List<Command> commands) {
		super();
		this.commands = commands;
	}

	public List<Command> getCommands() {
		return commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}

	@Override
	public void perform(String commandName, String... args) {
		if (!tryPerform(commandName, args)) {
			throw new IllegalArgumentException("Command not found");
		}
	}

	@Override
	public boolean tryPerform(String commandName, String... args) {
		for (Command command : commands) {
			if (command.getName().equals(commandName)) {
				command.setArgs(args);
				command.execute();
				return true;
			}
		}

		return false;
	}

}
