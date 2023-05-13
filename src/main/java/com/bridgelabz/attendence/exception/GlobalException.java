package com.bridgelabz.attendence.exception;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(value = AttendenceException.class)
    public String userAlreadyExist(AttendenceException empException) {
        return empException.getMessage();
	}
	

}
