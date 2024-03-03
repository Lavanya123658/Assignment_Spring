package com.leavemanagement.LeaveManagement.services;

import java.util.List;

import com.leavemanagement.LeaveManagement.entity.Users;
import com.leavemanagement.LeaveManagement.payload.UserDto;

public interface UserService {
//	UserDto createEmployee(UserDto userDto);
	UserDto createManager(UserDto userDto);
//	UserDto createEmployee(int mid, UserDto userDto);
	UserDto addEmployee(UserDto userDto);
	
	List<Users> findAllManagers();
}
