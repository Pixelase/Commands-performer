package com.github.pixelase.commands.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Command implements Comparable<Command> {
	protected String name;
	protected String description;
	protected List<String> args;

	public Command(String name, String description) {
		this(name, description, new ArrayList<String>());
	}

	private Command(String name, String description, List<String> args) {
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

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}

	protected boolean isArgsEmpty() {
		return args == null || args.isEmpty();
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
