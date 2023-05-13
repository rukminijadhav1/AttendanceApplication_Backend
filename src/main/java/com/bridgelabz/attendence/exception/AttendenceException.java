package com.bridgelabz.attendence.exception;



public class AttendenceException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AttendenceException(String message) {
		
		this.message = message;
	}

}
