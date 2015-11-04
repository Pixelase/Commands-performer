package com.github.pixelase.commands.utils.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CommandInputParser {
	public static CommandParseResult parse(String inputLine) throws IOException {
		List<String> matches = new ArrayList<>();
		CommandParseResult parseResult = null;

		Pattern p = Pattern.compile("[^\"&^\\s]+");

		Matcher m = p.matcher(inputLine);
		while (m.find()) {
			matches.add(m.group());
		}

		parseResult = (matches.isEmpty()) ? new CommandParseResult()
				: (matches.size() > 1) ? new CommandParseResult(matches.get(0), matches.subList(1, matches.size()))
						: new CommandParseResult(matches.get(0), new ArrayList<String>());

		return parseResult;

	}
}
