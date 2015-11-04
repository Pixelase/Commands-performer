package com.github.pixelase.commands.core;

import com.github.pixelase.commands.utils.input.CommandParseResult;

public interface Performer {
	void perform(CommandParseResult parseResult);

	boolean tryPerform(CommandParseResult parseResult);
}
