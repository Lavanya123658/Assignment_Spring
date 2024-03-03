package com.leavemanagement.LeaveManagement.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestParam;

import com.leavemanagement.LeaveManagement.entity.LeaveType;
import com.leavemanagement.LeaveManagement.exception.ManagerNotFoundException;
//import com.leavemanagement.LeaveManagement.entity.Role;
//import com.leavemanagement.LeaveManagement.entity.Users;
import com.leavemanagement.LeaveManagement.payload.LeaveTypeDto;
//import com.leavemanagement.LeaveManagement.payload.UserDto;
import com.leavemanagement.LeaveManagement.repository.LeaveTypeRepo;
import com.leavemanagement.LeaveManagement.services.LeaveTypeService;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService{
	
	private static final Logger logger = LoggerFactory.getLogger(LeaveTypeServiceImpl.class);
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private LeaveTypeRepo leaveTyperepo;

	@Override
	public LeaveTypeDto createLeave(LeaveTypeDto leaveTypeDto) {
		logger.info("Entering into leavetype creation method");
		LeaveType leavetype=this.modelMapper.map(leaveTypeDto, LeaveType.class);
		
		
		LeaveType savedleave = this.leaveTyperepo.save(leavetype);
		return this.modelMapper.map(savedleave,LeaveTypeDto.class);
	}

	@Override
	public List<LeaveType> findAllLeaveTypes() {
		return leaveTyperepo.findAllLeaveTypes();
	}
	
	@Override
	public LeaveType updateLeaveType(LeaveType leaveType) {
	    if (leaveType == null || leaveType.getName() == null) {
	        throw new IllegalArgumentException("Leave type and its name cannot be null for update operation");
	    }
	    LeaveType existingLeaveTypeOptional = leaveTyperepo.findByName(leaveType.getName());
	    if (existingLeaveTypeOptional==null) {	
	        throw new ManagerNotFoundException("Leave type with name " + leaveType.getName() + " not found");
	    }
	    LeaveType existingLeaveType = existingLeaveTypeOptional;
	    existingLeaveType.setMaxLeaves(leaveType.getMaxLeaves());
	    return leaveTyperepo.save(existingLeaveType);
	}
	
	public void deleteLeave(int id) {
		leaveTyperepo.deleteById(id);
	}

	@Override
	public LeaveType update(LeaveType leaveType) {
		// TODO Auto-generated method stub
		Long lid=leaveType.getId();
		LeaveType l=leaveTyperepo.findById(lid).get();
		l.setMaxLeaves(leaveType.getMaxLeaves());
		l.setName(leaveType.getName());
		
		return leaveTyperepo.save(l);
	}

}
