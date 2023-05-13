package com.bridgelabz.attendence.service;

import java.util.List;

import com.bridgelabz.attendence.dto.LoginDTO;
import com.bridgelabz.attendence.dto.RegisterDto;
import com.bridgelabz.attendence.model.AttendanceModel;
import com.bridgelabz.attendence.model.UserModel;

public interface IUserservice {

	UserModel registerUser(RegisterDto registerdto);

	String login(LoginDTO logindto);

	void logOutUser(String token);

	AttendanceModel signIn(String token);

	AttendanceModel signOut(String token);

	List<UserModel> getAllUser(String token);

}
