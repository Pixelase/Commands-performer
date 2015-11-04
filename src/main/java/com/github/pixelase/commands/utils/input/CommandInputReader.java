package com.github.pixelase.commands.utils.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandInputReader {
	public static String readLine(InputStream in) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		return br.readLine();
	}
}
