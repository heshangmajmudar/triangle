package com.test.processor;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.test.exception.InvalidTriangleException;

public class FileProcessor implements IProcessor {

	@Override
	public void process() {
		Console console = System.console();
		if (console == null) {
			throw new RuntimeException("Failed to get console instance");
		}

		String filePath = console.readLine("Enter data (csv) file path for input: ");
		try (Stream<String> stream = Files.lines(Paths.get(filePath.trim()))) {
			TriangleConsumer consumer = new TriangleConsumer();
			stream.forEach(consumer);
		} catch (IOException e) {
			System.err.println("Failed to read from file:" + filePath);
			e.printStackTrace();
		}
	}
	
	private class TriangleConsumer implements Consumer<String> {

		@Override
		public void accept(String str) {
			try {
				process(str);
			} catch (InvalidTriangleException e) {
				System.err.println(e.getMessage());
			}
		}
		
	}
}
