package com.github.pixelase.commands.utils.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandsInputParser {
	public static ParseResult parse(String inputLine) throws IOException {
		List<String> matches = new ArrayList<>();

		Pattern p = Pattern.compile("\\b[^\"&^\\s]+\\b");

		Matcher m = p.matcher(inputLine);
		while (m.find()) {
			matches.add(m.group());
		}

		String[] args = null;
		if (matches.isEmpty()) {
			return new ParseResult();
		} else if (matches.size() > 1) {
			args = new String[matches.size() - 1];
			for (int i = 0; i < args.length; i++) {
				args[i] = matches.get(i + 1);
			}
		}

		return new ParseResult(matches.get(0), args);

	}
}
