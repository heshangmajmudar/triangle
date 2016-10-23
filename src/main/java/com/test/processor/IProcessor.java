package com.test.processor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.test.exception.InvalidTriangleException;
import com.test.model.Triangle;

public interface IProcessor {

	enum Processors {
		console, file;

		public IProcessor getProcessor() {
			switch (this) {
			case file:
				return new FileProcessor();
			case console:
				return new ConsoleProcessor();
			default:
				System.err.println("Invalid Processor, using default (Console Processor)");
				return new ConsoleProcessor();
			}
		}
	}

	void process();

	default void process(String sidesStr) throws InvalidTriangleException {
		List<Double> sides = Arrays.stream(sidesStr.split(","))
				.map(side -> Double.valueOf(side.isEmpty() ? "-1" : side))
				.collect(Collectors.toList());
		if (sides.size() != 3) {
			throw new InvalidTriangleException("Number of sides can only be 3 " + sides);
		}

		Triangle triangle = new Triangle(sides);

		if (!triangle.hasValidSides()) {
			throw new InvalidTriangleException(triangle + " has one of the side <= 0");
		}

		if (!triangle.passesInequalityTheorem()) {
			throw new InvalidTriangleException(triangle + " does not pass inequality threorem");
		}
		
		System.out.println(triangle.getTriangleType());
	}
}
