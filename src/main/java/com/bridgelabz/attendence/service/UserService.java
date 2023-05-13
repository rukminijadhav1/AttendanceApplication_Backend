package com.bridgelabz.attendence.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.attendence.Utilities.JwtUtilities;
import com.bridgelabz.attendence.dto.LoginDTO;
import com.bridgelabz.attendence.dto.RegisterDto;
import com.bridgelabz.attendence.exception.AttendenceException;
import com.bridgelabz.attendence.model.AttendanceModel;
import com.bridgelabz.attendence.model.UserModel;
import com.bridgelabz.attendence.repository.AttendanceRepo;
import com.bridgelabz.attendence.repository.UserRepository;

@Service
public class UserService implements IUserservice{
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	AttendanceRepo attendancerepo;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Autowired
	JwtUtilities jwtUtility;

	private Temporal startTime;

	private Temporal endTime;


	@Override
	public UserModel registerUser(RegisterDto registerdto) {
		if (repo.findByUsername(registerdto.getUsername()).isPresent()) {
			throw new AttendenceException("user is  present");

		} else {

			UserModel userModel = modelmapper.map(registerdto, UserModel.class);
			userModel.setRole("User");
			repo.save(userModel);
		return null;
}
	}

	@Override
	public String login(LoginDTO logindto) {
		if (repo.findByUsername(logindto.getUsername()) != null) {
			if (repo.findByUsername(logindto.getUsername()).get().getPassword()
					.equals(logindto.getPassword())) {
					String token = jwtUtility.generateToken(logindto);
					UserModel userModel = repo.findByUsername(logindto.getUsername()).get();
					userModel.setLogin(true);
					

					repo.save(userModel);
					return token;
			}
			throw new AttendenceException("Check your Password");

		}
		throw new AttendenceException("check Email");
}
	@Override
	public void logOutUser(String token) {
		String username = jwtUtility.getusernameFromToken(token);
		Optional<UserModel> usermodel = repo.findByUsername(username);
		if (usermodel.isPresent()) {
			if (usermodel.get().isLogin()) {
				usermodel.get().setLogin(false);
				repo.save(usermodel.get());

			} else
				throw new AttendenceException("user is not active");
		} else
			throw new AttendenceException("invalid email");

	}

	@Override
	public AttendanceModel signIn(String token) {
		String username = jwtUtility.getusernameFromToken(token);
		UserModel userModel = repo.findByUsername(username).get();
		if(userModel.isLogin()) {
			if(userModel.isSignIN()) {
				throw new AttendenceException("user already signIn");
				
			}
			else {
				AttendanceModel attendance=new AttendanceModel(LocalDate.now(), userModel);
				attendance.setSignIn(LocalTime.now());
				attendance.setSignOut(LocalTime.ofSecondOfDay(0));
				
				userModel.setSignIN(true);
				attendance.setFullday(true);
				attendance.setLate(false);
				attendance.setDate(LocalDate.now());
				attendance.getTimeDuration();
				repo.save(userModel);
				return attendancerepo.save(attendance);
			}
		}
		
		
		 throw new AttendenceException("Invalid User");
	}

	@Override
	public AttendanceModel signOut(String token) {
		String username = jwtUtility.getusernameFromToken(token);
		UserModel userModel = repo.findByUsername(username).get();
		if(userModel.isLogin()) {
			AttendanceModel attendance=new AttendanceModel(LocalDate.now(), userModel);
			if(attendance!=null) {
				attendance.setSignOut(LocalTime.now());
				userModel.setSignIN(false);
				repo.save(userModel);
				return attendancerepo.save(attendance);
				}
			 }
		throw new AttendenceException("Invalid User");
	}

	@Override
	public List<UserModel> getAllUser(String token) {
		String username = jwtUtility.getusernameFromToken(token);
		UserModel userModel = repo.findByUsername(username).get();
		if(userModel.getRole().equals("admin") && userModel.isLogin()) {
		List<UserModel> list=repo.findAll();
		return list;
	}
	throw new AttendenceException("login as admin");
	
}
	
}
	

