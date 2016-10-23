package com.test.exception;

public class InvalidTriangleException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidTriangleException() {
		super();
	}

	public InvalidTriangleException(String msg) {
		super(msg);
	}
	
	public InvalidTriangleException(Throwable th) {
		super(th);
	}

	public InvalidTriangleException(String msg, Throwable th) {
		super(msg, th);
	}
}
