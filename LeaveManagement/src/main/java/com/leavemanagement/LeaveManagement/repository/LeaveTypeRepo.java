package com.leavemanagement.LeaveManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leavemanagement.LeaveManagement.entity.LeaveType;
//import com.leavemanagement.LeaveManagement.entity.Users;
//import com.leavemanagement.LeaveManagement.serviceImpl.Optional;
//import java.util.Optional;
@Repository
public interface LeaveTypeRepo extends JpaRepository<LeaveType, Integer>{
	@Query("select u from LeaveType u")
	List<LeaveType> findAllLeaveTypes();

	LeaveType findByName(String name);

	Optional<LeaveType> findById(Long lid);
}
