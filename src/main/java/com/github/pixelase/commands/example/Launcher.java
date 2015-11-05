package com.github.pixelase.commands.example;

import java.nio.file.Paths;

import com.github.pixelase.commands.core.Performer;
import com.github.pixelase.commands.utils.input.CommandInputParser;
import com.github.pixelase.commands.utils.input.CommandInputReader;
import com.github.pixelase.commands.utils.input.CommandParseResult;

public class Launcher {
	public static void main(String[] args) {
		try {
			Performer performer = new ExampleComandsPerformer();
			CommandParseResult parseResult = null;

			while (true) {
				System.out.print(Paths.get("").toAbsolutePath().toString() + ">");

				try {
					parseResult = CommandInputParser.parse(CommandInputReader.readLine(System.in));

					if (!performer.tryPerform(parseResult.getCommandName(), parseResult.getArgs())) {
						System.out.println("Command not found.");
					}
				} catch (Exception e) {
					System.out.println("Something went wrong: " + e.getMessage());
				}
			}

		} catch (Exception e) {
			System.out.println("Critical error: " + e.getMessage());
		}
	}
}
