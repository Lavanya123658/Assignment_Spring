package com.leavemanagement.LeaveManagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leavemanagement.LeaveManagement.entity.LeaveType;
//import com.leavemanagement.LeaveManagement.entity.Users;
import com.leavemanagement.LeaveManagement.payload.LeaveTypeDto;

@Service
public interface LeaveTypeService {

	LeaveTypeDto createLeave(LeaveTypeDto leaveTypeDto);

	List<LeaveType> findAllLeaveTypes();

	LeaveType updateLeaveType(LeaveType leaveType);
	
	void deleteLeave(int id);
	
	LeaveType update(LeaveType leaveType);

}
