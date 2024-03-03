package com.leavemanagement.LeaveManagement.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.leavemanagement.LeaveManagement.controller.ManagerController;
import com.leavemanagement.LeaveManagement.entity.Role;
import com.leavemanagement.LeaveManagement.entity.Users;
import com.leavemanagement.LeaveManagement.exception.ManagerNotFoundException;
import com.leavemanagement.LeaveManagement.payload.UserDto;
import com.leavemanagement.LeaveManagement.repository.UserRepo;
import com.leavemanagement.LeaveManagement.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDto addEmployee(UserDto userDto) {
	    logger.info("Entering into employee creation method");
	    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
	    
	    int mid=userDto.getManagerId();
	    
	    List<Users> managers=userRepo.findAllManagers();
	    
	    Users manager=managers.stream().filter(m->m.getId()==mid).findFirst().orElseThrow(
	    		()->new ManagerNotFoundException(String.format("Manager id %d not found",mid)));
	    
	    
	   
	    logger.info("Requested mid: "+mid);
	    
	
	    logger.info("checking manager");	 
	
	    logger.info(manager.getName());
	    Users user = modelMapper.map(userDto, Users.class);
	    
	    
	    user.setRole(Role.EMPLOYEE);
	    
	    user.setManager(manager);

	    // Save the user entity
	    Users savedUser = userRepo.save(user);
	    return modelMapper.map(savedUser, UserDto.class);
//	  
	
	    
	}
	//Service method to create employee
//	@Override
//	public UserDto createEmployee(UserDto userDto) {
//		logger.info("Entering into employee creation method");
//		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//		Users user = this.modelMapper.map(userDto, Users.class);
//		user.setRole(Role.EMPLOYEE);	
//		Users savedUser = this.userRepo.save(user);
//		return this.modelMapper.map(savedUser,UserDto.class);
//	}
	
//	@Override
//	public UserDto createEmployee(UserDto userDto) {
//	    logger.info("Entering into employee creation method");
//	    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//	    
//	    // Retrieve the manager from the repository using managerId
//	    Users manager = userRepo.findById(userDto.getManagerId())
//	                            .orElseThrow(() -> new ManagerNotFoundException("Manager with id " + userDto.getManagerId() + " not found"));
//	    
//	    // Map UserDto to Users entity
//	    userDto.setManagerId(manager.getId());
//	    
//	    Users user = modelMapper.map(userDto, Users.class);
//	    
//	    // Set the role and manager
//	    user.setRole(Role.EMPLOYEE);
////	    user.setManager(manager);
//	    userDto.setManagerId(manager.getId());
//	    
//	    // Save the user entity
//	    Users savedUser = userRepo.save(user);
//	    
//	    // Map the saved user back to UserDto and return
//	    return modelMapper.map(savedUser, UserDto.class);
//	}
	//working code
//	@Override
//	public UserDto createEmployee(int mid,UserDto userDto) {
//	    logger.info("Entering into employee creation method");
//	    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//
//	    // Retrieve the manager from the repository using managerId
//	    logger.info("checking manager");	 
//	    Users manager = userRepo.findById(mid).orElseThrow(() -> new ManagerNotFoundException(String.format("Manager id %d not found",mid)));
//	    
//	    // Map UserDto to Users entity
//	    Users user = modelMapper.map(userDto, Users.class);
//	    
//	    // Set the role and manager
//	  //  if(manager.getId()==mid) {
//	    logger.info(manager.getRole().toString());
//	    if(manager.getRole().toString().equals("MANAGER")) {
//	    user.setRole(Role.EMPLOYEE);
//	    
//	    user.setManager(manager);
//
//	    // Save the user entity
//	    Users savedUser = userRepo.save(user);
//	    return modelMapper.map(savedUser, UserDto.class);
//	    }
//	    else {
//	    	throw new ManagerNotFoundException(String.format("Manager with %d is not present",mid));
//	    }
//
//	    // Map the saved user back to UserDto and return
//	    
//	}

//	@Override
//	public UserDto createEmployee(UserDto userDto) {
//	    logger.info("Entering into employee creation method");
//	    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//	    
//	    // Retrieve the manager from the repository using managerId
//	    Users manager = userRepo.findById(userDto.getManagerId())
//	                            .orElseThrow(() -> new ManagerNotFoundException("Manager with id " + userDto.getManagerId() + " not found"));
//	    
//	    // Map UserDto to Users entity
//	    Users user = modelMapper.map(userDto, Users.class);
//	    
//	    // Set the role
//	    user.setRole(Role.EMPLOYEE);
//	    
//	    // Save the user entity
//	    Users savedUser = userRepo.save(user);
//	    
//	    // Assign the manager to the new employee
//	    savedUser.setManager(manager);
//	    
//	    // Save the updated user entity
//	    savedUser = userRepo.save(savedUser);
//	    
//	    // Map the saved user back to UserDto and return
//	    return modelMapper.map(savedUser, UserDto.class);
//	}


	
	//Service method to create manager
	@Override
	public UserDto createManager(UserDto userDto) {
		logger.info("Entering into manager creation method");
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Users user = this.modelMapper.map(userDto, Users.class);
		user.setRole(Role.MANAGER);
		Users savedUser = this.userRepo.save(user);
		return this.modelMapper.map(savedUser,UserDto.class);
	}

	@Override
	public List<Users> findAllManagers() {
		// TODO Auto-generated method stub
		return userRepo.findAllManagers();
	}

//	@Override
//	public UserDto createEmployee(int mid, UserDto userDto) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
