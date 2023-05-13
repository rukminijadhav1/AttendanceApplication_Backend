package com.bridgelabz.attendence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.attendence.Response;
import com.bridgelabz.attendence.dto.LoginDTO;
import com.bridgelabz.attendence.dto.RegisterDto;
import com.bridgelabz.attendence.model.AttendanceModel;
import com.bridgelabz.attendence.model.UserModel;

import com.bridgelabz.attendence.service.IUserservice;



@RestController
@RequestMapping("/USer")
public class UserController {
	
	@Autowired
	IUserservice service1;
	
	
	

	@PostMapping("/Registeruser")
	public ResponseEntity<Response> registerUser(@RequestBody RegisterDto registerdto) {
		UserModel usermodel = service1.registerUser(registerdto);
		Response response = new Response("user Register successfully", usermodel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/Login")
	public ResponseEntity<Response> login(@RequestBody LoginDTO logindto) {
		String token=service1.login(logindto);
		Response response = new Response("Login Successfully",token);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	 @PutMapping("/Logout")
     public ResponseEntity<Response> logOutUser(@RequestHeader String token) {
         service1.logOutUser(token);
         Response response = new Response("User Logout");
         return  new ResponseEntity<>(response, HttpStatus.OK);
     }

	 @PostMapping("SignIn_Attendence")
	    public ResponseEntity<Response> SignInAttendence(@RequestParam String token) {
	        AttendanceModel attendanceModel = service1.signIn(token);
	        Response response = new Response( "SignIn Successful",attendanceModel);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
	 @PutMapping("SignOUT_Attendence")
	    public ResponseEntity<Response> SignOUTAttendence(@RequestParam String token) {
	     AttendanceModel attendanceModel = service1.signOut(token);
	        Response response = new Response( "SignOut Successful",attendanceModel);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
	 @GetMapping("fetchUsers")
	    public ResponseEntity<Response> getallusers(@RequestParam String token) {
	        List<UserModel> usermodel = service1.getAllUser(token);
	        Response response = new Response(" Users Data",usermodel);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	}


