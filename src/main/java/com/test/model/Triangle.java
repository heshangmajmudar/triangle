package com.test.model;

import java.util.List;

public class Triangle {

	private double sideA;
	private double sideB;
	private double sideC;

	public Triangle(List<Double> sides) {
		sideA = sides.get(0);
		sideB = sides.get(1);
		sideC = sides.get(2);
	}

	public boolean hasValidSides() {
		return sideA > 0 && sideB > 0 && sideC > 0;
	}
		
	public boolean passesInequalityTheorem() {
		//Inequality theorem
		return sideA < sideB + sideC && sideB < sideA + sideC && sideC < sideA + sideB;
	}
	
	public String getTriangleType() {
		if (sideA == sideB && sideB == sideC) {
			return this + " is " + TriangleType.EQUILATERAL.name();
		}
		
		if (sideA == sideB || sideB == sideC || sideC == sideA) {
			return this + " is " + TriangleType.ISOCELES.name();
		}
		
		return this + " is " + TriangleType.SCALENE.name();
	}
	
	@Override
	public String toString() {
		return "Triangle(" + sideA + "," + sideB + "," + sideC + ")";
	}
}
