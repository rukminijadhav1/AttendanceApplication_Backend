package com.bridgelabz.attendence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.attendence.service.IUserservice;

@RestController
@RequestMapping("/Attendence")
public class AttendenceController {
	
	@Autowired
	IUserservice service;
	
	

}
