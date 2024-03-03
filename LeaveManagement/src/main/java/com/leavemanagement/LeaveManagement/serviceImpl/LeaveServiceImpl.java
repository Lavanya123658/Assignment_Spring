package com.leavemanagement.LeaveManagement.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagement.LeaveManagement.entity.Leave;
import com.leavemanagement.LeaveManagement.entity.Role;
import com.leavemanagement.LeaveManagement.entity.Users;
import com.leavemanagement.LeaveManagement.exception.APIException;
import com.leavemanagement.LeaveManagement.exception.InvalidLeaveDatesException;
import com.leavemanagement.LeaveManagement.exception.LeaveNotFoundException;
import com.leavemanagement.LeaveManagement.exception.ManagerNotFoundException;
import com.leavemanagement.LeaveManagement.exception.ResourceNotFoundException;
import com.leavemanagement.LeaveManagement.payload.LeaveDto;
import com.leavemanagement.LeaveManagement.payload.StatusDto;
import com.leavemanagement.LeaveManagement.payload.UserDto;
import com.leavemanagement.LeaveManagement.repository.LeaveRepo;
import com.leavemanagement.LeaveManagement.repository.UserRepo;
import com.leavemanagement.LeaveManagement.services.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService{
	
	private static final Logger logger = LoggerFactory.getLogger(LeaveServiceImpl.class);
	
	@Autowired
	private LeaveRepo leaveRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private UserRepo userRepo;

	//Service method to apply for leave
	@Override
	public LeaveDto applyLeave(LeaveDto leaveDto,Integer userId) throws InvalidLeaveDatesException {
		logger.info("Entering into apply leave  method");
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","user id",userId));
		if(leaveDto.getStartDate().after(leaveDto.getEndDate())) {
			throw new InvalidLeaveDatesException("Start date must be before end date");
		}
		leaveDto.setUserId(userId);
		leaveDto.setStatus("Pending");
		Leave leave = this.modelMapper.map(leaveDto, Leave.class);
		Leave savedLeave = this.leaveRepo.save(leave);
		return this.modelMapper.map(savedLeave, LeaveDto.class);
	}

	//Service method to get leaves by employee id
	@Override
	public List<LeaveDto> getLeavesByEmployeeId(Integer userId) throws ResourceNotFoundException{
		logger.info("Entering into  getleavesbyemployeeid method");
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","user id",userId));
		List<Leave> leaves = this.leaveRepo.findByUserId(userId);
		List<LeaveDto> leaveDtos = leaves.stream().map((leave)->this.modelMapper.map(leave, LeaveDto.class)).collect(Collectors.toList());
		return leaveDtos;
	}

	//Service method to get the pending leaves
	@Override
	public List<LeaveDto> getPendingLeaves() {
		logger.info("Entering into  getPendingleaves method");
		List<Leave> leaves = this.leaveRepo.findByStatus("Pending");
		List<LeaveDto> leaveDtos = leaves.stream().map((leave)->this.modelMapper.map(leave, LeaveDto.class)).collect(Collectors.toList());
		return leaveDtos;
	}

	//Service method to approve the leave
	@Override
	public LeaveDto setStatus(StatusDto statusDto, Integer lid,Integer mid) {
		logger.info("Entering into approve leave method");
		Leave leave  = this.leaveRepo.findById(lid).orElseThrow(()->new ResourceNotFoundException("leave","leave id",lid));
		Users manager = userRepo.findById(mid).orElseThrow(() -> new ManagerNotFoundException(String.format("Manager id %d not found",mid)));
		Users user=this.userRepo.findById(leave.getUserId()).orElseThrow(()  -> new ManagerNotFoundException("USer with "+leave.getUserId()+" is not present"));
		  
		logger.info("mid is" +user.getManager().getId());
		    logger.info(manager.getRole().toString());
//		    if(manager.getRole().toString().equals("MANAGER")) {
//		    	if(leave.getStatus().equals("Pending")) {
//					leave.setStatus(statusDto.getStatus());
//					leave.setComment(statusDto.getComment());
//					leave.setManager(manager);
//					Leave savedLeave = this.leaveRepo.save(leave);
//					return this.modelMapper.map(savedLeave,LeaveDto.class);
//				}
//		    	else {
//		    		throw new LeaveNotFoundException("Leave is either already approved or rejected");
//		    	}
//		    	
//			 }
//			 else {
//			    	throw new ManagerNotFoundException(String.format("Manager with %d is not present",mid));
//			 }
		    if(user.getManager().getId()==mid) {
		    	if(leave.getStatus().equals("Pending")) {
					leave.setStatus(statusDto.getStatus());
					leave.setComment(statusDto.getComment());
					leave.setManager(manager);
					Leave savedLeave = this.leaveRepo.save(leave);
					return this.modelMapper.map(savedLeave,LeaveDto.class);
				}
		    	else {
		    		throw new LeaveNotFoundException("Leave is either already approved or rejected");
		    	}
		    	
			 }
			 else {
			    	throw new ManagerNotFoundException(String.format("Sorry!! You're not the manager of respected user %s",user.getName()));
			 }
		
	}
	
	
	//Service method to get all leaves
	@Override
	public List<LeaveDto> getAllLeaves() {
		logger.info("Entering into  getAllLeaves method");
		List<Leave> leaves = this.leaveRepo.findAll();
		List<LeaveDto> leaveDtos = leaves.stream().map((leave)->this.modelMapper.map(leave, LeaveDto.class)).collect(Collectors.toList());
		return leaveDtos;
	}
	
}
