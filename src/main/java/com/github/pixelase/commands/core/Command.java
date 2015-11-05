package com.github.pixelase.commands.core;

public abstract class Command implements Comparable<Command> {
	protected String name;
	protected String description;
	protected String[] args;

	public Command(String name, String description) {
		this(name, description, new String[0]);
	}

	private Command(String name, String description, String[] args) {
		this.name = name;
		this.description = description;
		this.args = args;
	}

	public abstract void execute();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	protected boolean isArgsEmpty() {
		return args == null || args.length == 0;
	}

	@Override
	public int compareTo(Command command) {
		return name.compareTo(command.getName());
	}

	@Override
	public String toString() {
		return String.format("%s\t%-10s", name, description);
	}
}
