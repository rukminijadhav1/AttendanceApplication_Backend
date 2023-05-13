package com.bridgelabz.attendence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.attendence.model.AttendanceModel;
import com.bridgelabz.attendence.model.UserModel;

@Repository
public interface AttendanceRepo extends JpaRepository<AttendanceModel, Integer> {

	
	


}
