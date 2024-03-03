package com.leavemanagement.LeaveManagement.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leavemanagement.LeaveManagement.entity.Users;
import com.leavemanagement.LeaveManagement.payload.BackendResponse;
import com.leavemanagement.LeaveManagement.payload.JWTAuthResponse;
import com.leavemanagement.LeaveManagement.payload.LoginDto;
import com.leavemanagement.LeaveManagement.payload.UserDto;
import com.leavemanagement.LeaveManagement.repository.UserRepo;
import com.leavemanagement.LeaveManagement.security.JwtTokenProvider;
import com.leavemanagement.LeaveManagement.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	 
	@Autowired
	private UserRepo userRepo;
	
	//post method to register manager
	@PostMapping("/register/manager")
	public ResponseEntity<BackendResponse> createManager(@RequestBody UserDto userDto){
		logger.info("Received request to /api/auth/register/manager");
		BackendResponse backendResponse = new BackendResponse();
		
		try {
				StringBuilder error = new StringBuilder("Field ");
				if(userDto.getEmail()==null) {
					error.append("Email is not mentioned");
				}
				if(userDto.getEmail().isEmpty()) {
					error.append("Email should not be empty");
				}
				if(userDto.getPassword()==null) {
					error.append("Password is not mentioned");
				}
				if(userDto.getPassword().isEmpty()) {
					error.append("Password should not be empty");
				}
				if(userDto.getMobile()==null) {
					error.append("Mobile Num is not mentioned");
				}
				if(userDto.getMobile().isEmpty()) {
					error.append("Mobile Num should not be empty");
				}
				if(userDto.getName()==null) {
					error.append("Name is not mentioned");
				}
				if(userDto.getName().isEmpty()) {
					error.append("Name should not be empty");
				}
				if(userDto.getPersonalEmail()==null) {
					error.append("Personal Email is not mentioned");
				}
				if(userDto.getPersonalEmail().isEmpty()) {
					error.append("Personal Email should not be empty");
				}
				if(userDto.getDateOfJoining()==null) {
					error.append("Date of joining is not mentioned");
				}
				
				
				Optional<Users> user = userRepo.findByEmail(userDto.getEmail());
				if(user.isPresent()) {
					error.append("Manager already exists");
				}
				if(!error.toString().equals("Field ")) {
					backendResponse.setMessage(error.toString());
					backendResponse.setStatus("fail");
					backendResponse.setData("false");
					return new ResponseEntity<>(backendResponse,HttpStatus.BAD_REQUEST);
				}
			
			UserDto savedUserDto = this.userService.createManager(userDto);
			backendResponse.setMessage("Manager created Succesfully");
			backendResponse.setStatus("Pass");
			backendResponse.setData("Saved");
			return new ResponseEntity<>(backendResponse,HttpStatus.CREATED);
		}catch(Exception e) {
			backendResponse.setMessage("Manager with email already Exists=====");
			backendResponse.setStatus("fail");
			backendResponse.setData("Null");
			return new ResponseEntity<>(backendResponse,HttpStatus.BAD_REQUEST);
		}
		
	
		
	}
	
//	//post method to register employee
//	@PostMapping("/register/employee/{mid}")
//	public ResponseEntity<BackendResponse> createEmployee(@PathVariable (name="mid") int mid,@RequestBody UserDto userDto){
//		logger.info("Received request to /api/auth/register/employee");
//		BackendResponse backendResponse = new BackendResponse();
//		
//		try {
//			logger.info("in try block");
//			StringBuilder error = new StringBuilder("Field ");
//			if(userDto.getEmail()==null) {
//				error.append("Email is not mentioned");
//			}
//			if(userDto.getEmail().isEmpty()) {
//				error.append("Email should not be empty");
//			}
//			if(userDto.getPassword()==null) {
//				error.append("Password is not mentioned");
//			}
//			if(userDto.getPassword().isEmpty()) {
//				error.append("Password should not be empty");
//			}
//			if(userDto.getMobile()==null || userDto.getMobile().isEmpty()) {
//				error.append("Mobile Num is not mentioned or empty");
//			}
//			
////			if(userDto.getName()==null) {
////				logger.info("in name checking null method");
////				error.append("Name is not mentioned");
////				logger.info(error.toString());
////			}
////			if(userDto.getName().isEmpty()) {
////				logger.info("in name checking empty method");
////				error.append("Name should not be empty");
////			}
//			 if(userDto.getName()==null || userDto.getName().isEmpty()) {
//		            error.append("Name is missing or empty");
//		        }
//			if(userDto.getPersonalEmail()==null || userDto.getPersonalEmail().isEmpty()) {
//				error.append("Personal Email is not mentioned or Empty");
//			}
//			
//			
//			if(userDto.getDateOfJoining()==null) {
//				error.append("Date of joining is not mentioned");
//			}
//			
//			Optional<Users> user = userRepo.findByEmail(userDto.getEmail());
//			if(user.isPresent()) {
//				error.append("Employee already exists");
//			}
//			logger.info("error msg: "+error.toString());
//			if(!error.toString().equals("Field ")) {
//				backendResponse.setMessage(error.toString());
//				backendResponse.setStatus("fail");
//				backendResponse.setData("false");
//				return new ResponseEntity<>(backendResponse,HttpStatus.BAD_REQUEST);
//			}
//			UserDto savedUserDto = this.userService.createEmployee(mid,userDto);
//			backendResponse.setMessage("Employee created Succesfully");
//			backendResponse.setStatus("Pass");
//			backendResponse.setData(savedUserDto);
//			return new ResponseEntity<>(backendResponse,HttpStatus.CREATED);
//		}catch(Exception e) {
//			logger.info("in catch block");
//			
//			backendResponse.setMessage("Employee with email already Exists");
//			backendResponse.setStatus("fail");
//			backendResponse.setData(e.getMessage());
//			return new ResponseEntity<>(backendResponse,HttpStatus.BAD_REQUEST);
//		}
//	}
//	
	//post method to register employee
		@PostMapping("/add/employee")
		public ResponseEntity<BackendResponse> addEmployee(@RequestBody UserDto userDto){
			logger.info("Received request to /api/auth/register/employee");
			BackendResponse backendResponse = new BackendResponse();
			
			try {
				logger.info("in try block");
				StringBuilder error = new StringBuilder("Field ");
				if(userDto.getEmail()==null) {
					error.append("Email is not mentioned");
				}
				if(userDto.getEmail().isEmpty()) {
					error.append("Email should not be empty");
				}
				if(userDto.getPassword()==null) {
					error.append("Password is not mentioned");
				}
				if(userDto.getPassword().isEmpty()) {
					error.append("Password should not be empty");
				}
				if(userDto.getMobile()==null || userDto.getMobile().isEmpty()) {
					error.append("Mobile Num is not mentioned or empty");
				}
				
//				if(userDto.getName()==null) {
//					logger.info("in name checking null method");
//					error.append("Name is not mentioned");
//					logger.info(error.toString());
//				}
//				if(userDto.getName().isEmpty()) {
//					logger.info("in name checking empty method");
//					error.append("Name should not be empty");
//				}
				 if(userDto.getName()==null || userDto.getName().isEmpty()) {
			            error.append("Name is missing or empty");
			        }
				if(userDto.getPersonalEmail()==null || userDto.getPersonalEmail().isEmpty()) {
					error.append("Personal Email is not mentioned or Empty");
				}
				
				
				if(userDto.getDateOfJoining()==null) {
					error.append("Date of joining is not mentioned");
				}
				
				Optional<Users> user = userRepo.findByEmail(userDto.getEmail());
				if(user.isPresent()) {
					error.append("Employee already exists");
				}
				logger.info("error msg: "+error.toString());
				if(!error.toString().equals("Field ")) {
					backendResponse.setMessage(error.toString());
					backendResponse.setStatus("fail");
					backendResponse.setData("false");
					return new ResponseEntity<>(backendResponse,HttpStatus.BAD_REQUEST);
				}
				UserDto savedUserDto = this.userService.addEmployee(userDto);
				backendResponse.setMessage("Employee created Succesfully");
				backendResponse.setStatus("Pass");
				backendResponse.setData(savedUserDto);
				return new ResponseEntity<>(backendResponse,HttpStatus.CREATED);
			}catch(Exception e) {
				logger.info("in catch block");
				
				backendResponse.setMessage("Employee with email already Exists");
				backendResponse.setStatus("fail");
				backendResponse.setData(e.getMessage());
				return new ResponseEntity<>(backendResponse,HttpStatus.BAD_REQUEST);
			}
		}
		
	
	//post method to login
	@PostMapping("/login")
	public ResponseEntity<BackendResponse> loginUser(@RequestBody LoginDto loginDto){
		logger.info("Received request to /api/auth/login");
		BackendResponse backendResponse = new BackendResponse();
		
		try {
			StringBuilder error = new StringBuilder("Field ");
			logger.info("=============="+error);
			if(loginDto.getEmail()==null) {
				error.append("Email is not mentioned");
			}
			if(loginDto.getEmail().isEmpty()) {
				error.append("Email should not be empty");
			}
			if(loginDto.getPassword()==null) {
				error.append("Password is not mentioned");
			}
			if(loginDto.getPassword().isEmpty()) {
				error.append("Password should not be empty");
			}
			
			if(!error.toString().equals("Field ")) {
				backendResponse.setMessage(error.toString());
				backendResponse.setStatus("fail");
				backendResponse.setData("false");
				return new ResponseEntity<>(backendResponse,HttpStatus.BAD_REQUEST);
			}
			Authentication authentication = 
					authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
					);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = jwtTokenProvider.generateToken(authentication);
			if(token.isEmpty()) {
				backendResponse.setMessage("Token is Empty");
				backendResponse.setStatus("fail");
				backendResponse.setData("false");
				return new ResponseEntity<>(backendResponse,HttpStatus.BAD_REQUEST);
			}
			JWTAuthResponse jwtAuthResponse = new JWTAuthResponse(token);
			backendResponse.setMessage("Token Generated and validated successfully == Login Successfull");
			backendResponse.setStatus("Pass");
			backendResponse.setData(jwtAuthResponse);
			return ResponseEntity.ok(backendResponse);
			
		}catch(Exception e) {
			backendResponse.setMessage("Login Unsuccesssful");
			backendResponse.setStatus("fail");
			backendResponse.setData(e);
			return new ResponseEntity<>(backendResponse,HttpStatus.BAD_REQUEST);
			
		}
		
	}
	 
	@GetMapping("/managerlist")
	public List<Users> findAllManagers(){
		return userService.findAllManagers();
	}

	
}
