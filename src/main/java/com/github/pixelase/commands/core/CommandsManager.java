package com.github.pixelase.commands.core;

import java.util.ArrayList;
import java.util.List;

public class CommandsManager implements CommandsPerformer {
	protected List<Command> commands;

	protected CommandsManager() {
		this(new ArrayList<Command>());
	}

	protected CommandsManager(List<Command> commands) {
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

	public static class Builder {
		private final List<Command> commands;

		public Builder() {
			this(new ArrayList<Command>());
		}

		private Builder(List<Command> commands) {
			this.commands = commands;
		}

		public Builder add(Command command) {
			this.commands.add(command);

			return this;
		}

		public List<Command> getCommands() {
			return commands;
		}

		public CommandsManager build() {
			commands.sort(null);
			return new CommandsManager(commands);
		}

	}
}
