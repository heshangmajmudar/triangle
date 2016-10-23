package com.test.processor;

import java.io.Console;

import com.test.exception.InvalidTriangleException;

public class ConsoleProcessor implements IProcessor {

	@Override
	public void process() {
		Console console = System.console();
		if (console == null) {
			throw new RuntimeException("Failed to get console instance");
		}

		String sidesString = console.readLine("Enter comma separated sides or end to terminate: ");
		while (!sidesString.equalsIgnoreCase("end")) {
			try {
				process(sidesString);
			} catch (InvalidTriangleException e) {
				System.err.println(e.getMessage());
			}
			sidesString = console.readLine("Enter comma separated sides or end to terminate: ");
		} 
	}
}
