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

public class ExampleComandsManager extends CommandsManager {

	public ExampleComandsManager() {
		this(new ArrayList<Command>());

		/*
		 * exit command
		 */
		commands.add(new Command("exit", "It shuts down the program.") {
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
		});

		/*
		 * help command
		 */
		commands.add(new Command("help", "Display the help information about commands.") {
			@Override
			public void execute() {
				System.out.println();
				for (Command command : commands) {
					System.out.println(command);
				}
				System.out.println();
			}
		});

		/*
		 * dir command
		 */
		commands.add(new Command("dir", "Recursively displays a list of files of the specified folder.") {
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
		});

		commands.sort(null);
	}

	public ExampleComandsManager(List<Command> commands) {
		super(commands);
	}

}
