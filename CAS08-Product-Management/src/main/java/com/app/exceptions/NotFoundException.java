package com.app.exceptions;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String msg) {
		super(msg);
	}
	public NotFoundException() {
		super("Not Found Exception");
	}
}
