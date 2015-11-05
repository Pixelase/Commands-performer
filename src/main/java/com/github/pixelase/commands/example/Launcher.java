package com.github.pixelase.commands.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.github.pixelase.commands.core.Command;
import com.github.pixelase.commands.core.CommandsManager;
import com.github.pixelase.commands.core.CommandsPerformer;
import com.github.pixelase.commands.utils.input.CommandInputParser;
import com.github.pixelase.commands.utils.input.CommandInputReader;
import com.github.pixelase.commands.utils.input.CommandParseResult;

public class Launcher {
	public static void main(String[] args) {
		try {
			final CommandsManager.Builder builder = new CommandsManager.Builder();
			CommandsPerformer performer = builder.add(new Command("exit", "It shuts down the program.") {
				@Override
				public void execute() {
					System.out.println();
					System.out.print("Program is closing");

					for (int i = 0; i < 3; i++) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
						System.out.print(".");
					}

					System.out.println();
					System.exit(0);
				}
			}).add(new Command("help", "Display the help information about commands.") {
				@Override
				public void execute() {
					System.out.println();
					for (Command command : builder.getCommands()) {
						System.out.println(command);
					}
					System.out.println();
				}
			}).add(new Command("dir", "Recursively displays a list of files of the specified folder.") {
				@Override
				public void execute() {

					final List<File> files = new ArrayList<File>();
					try {
						Files.walk(Paths.get("")).forEach(new Consumer<Path>() {
							@Override
							public void accept(Path filePath) {
								if (Files.isRegularFile(filePath)) {
									files.add(new File(filePath.toString()));
								}
							}
						});
					} catch (IOException e) {
						throw new RuntimeException(e);
					}

					System.out.println();
					for (File file : files) {
						System.out.println(file.getName());
					}
					System.out.println();
				}
			}).build();

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
