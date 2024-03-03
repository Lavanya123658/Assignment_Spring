package com.leavemanagement.LeaveManagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leavemanagement.LeaveManagement.entity.LeaveType;
import com.leavemanagement.LeaveManagement.entity.Users;
import com.leavemanagement.LeaveManagement.payload.BackendResponse;
//import com.leavemanagement.LeaveManagement.payload.LeaveDto;
import com.leavemanagement.LeaveManagement.payload.LeaveTypeDto;
//import com.leavemanagement.LeaveManagement.serviceImpl.UserServiceImpl;
//import com.leavemanagement.LeaveManagement.payload.UserDto;
import com.leavemanagement.LeaveManagement.services.LeaveTypeService;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "http://localhost:4200")
public class LeaveTypeController {
	private static final Logger logger = LoggerFactory.getLogger(LeaveTypeController.class);
	@Autowired
	private LeaveTypeService leaveTypeService;

	@PostMapping("/leaves/create")
    public LeaveTypeDto createLeave(@RequestBody LeaveTypeDto leaveTypeDto) {
        
		
		logger.info("In leave type controller");
//		BackendResponse backendResponse = new BackendResponse();
//		LeaveTypeDto saved = this.leaveTypeService.createLeave(leaveTypeDto);
//		backendResponse.setMessage("Leavetype created Succesfully");
//		backendResponse.setStatus("Pass");
//		backendResponse.setData(saved);
//		return new ResponseEntity<>(backendResponse,HttpStatus.CREATED);
		return leaveTypeService.createLeave(leaveTypeDto);
		//return "Created successfully";
    }
	
	@GetMapping("/leaveslist")
	public List<LeaveType> findAllLeaveTypes(){
		return leaveTypeService.findAllLeaveTypes();
	}
	
	 @PutMapping("/updateLeave")
	    public ResponseEntity<LeaveType> updateLeaveType(@RequestBody LeaveType leaveType) {
	        
	        LeaveType updatedLeaveType = leaveTypeService.updateLeaveType(leaveType);
	        return ResponseEntity.ok(updatedLeaveType);
	    }
	 
	 @DeleteMapping("/deleteLeave")
	 public void deleteLeave(@RequestParam int id) {
		 leaveTypeService.deleteLeave(id);
	 }
	 
	 @PutMapping("/update")
	   public LeaveType update(@RequestBody LeaveType leaveType) {
		 return leaveTypeService.update(leaveType);
	 }
}
