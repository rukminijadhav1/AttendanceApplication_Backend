package com.bridgelabz.attendence.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class AttendanceModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private LocalDate date;
	private LocalTime signIn;
	private LocalTime signOut;
	private boolean isLate=false;
	private boolean isFullday=false;
	private long timeDuration;

	@ManyToOne
	private UserModel userModel;
	
	public AttendanceModel(LocalDate now, UserModel userModel2) {
		// TODO Auto-generated constructor stub
	}
	
	public int getid() {
		return id;
	}
	public LocalTime getSignIn() {
		return signIn;
	}
	public LocalTime getSignOut() {
		return signOut;
	}
	public boolean isLate() {
		return isLate;
	}
	public boolean isFullday() {
		return isFullday;
	}
	
	public UserModel getUserModel() {
		return userModel;
	}
	public void setid(int id) {
		this.id = id;
	}
	public void setSignIn(LocalTime signIn) {
		this.signIn = signIn;
	}
	public void setSignOut(LocalTime signOut) {
		this.signOut = signOut;
	}
	public void setLate(boolean isLate) {
		this.isLate = isLate;
	}
	public void setFullday(boolean isFullday) {
		this.isFullday = isFullday;
	}
	
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public LocalDate getDate() {
		return date;
	}

	public long getTimeDuration() {
		return timeDuration;
	}

	
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setTimeDuration(long timeDuration) {
		this.timeDuration = timeDuration;
	}

	public AttendanceModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
	
	
	
	

}
