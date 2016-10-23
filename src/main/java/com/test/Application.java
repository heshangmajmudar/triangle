package com.test;

import java.io.Console;

import com.test.processor.IProcessor.Processors;

public class Application {

	public static void main(String[] args) {

		Console console = System.console();
		if (console == null) {
			throw new RuntimeException("Failed to get console instance");
		}
		String input = console.readLine("Input from (console/file) or end to terminate: ");
		if (input.equalsIgnoreCase("end")) {
			System.exit(0);
		}
		try {
			Processors processor = Processors.valueOf(input);
			processor.getProcessor().process();
		} catch (IllegalArgumentException e) {
			if (e.getMessage().contains("No enum constant com.test.processor.IProcessor.Processors")) {
				System.err.println("Invalid option.....exiting.");
			} else {
				throw e;
			}
		}
	}
}
