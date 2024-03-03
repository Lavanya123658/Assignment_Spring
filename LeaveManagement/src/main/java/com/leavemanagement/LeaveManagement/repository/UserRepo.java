package com.leavemanagement.LeaveManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leavemanagement.LeaveManagement.entity.Users;

public interface UserRepo extends JpaRepository<Users,Integer>{

	Optional<Users> findByEmail(String email);
//	<Optional> Users findByEmail(String email);
	
	@Query("select u from Users u where u.role='MANAGER'")
	List<Users> findAllManagers();
}
