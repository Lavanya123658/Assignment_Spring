package com.leavemanagement.LeaveManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagement.LeaveManagement.entity.LeaveSummary;
import com.leavemanagement.LeaveManagement.repository.LeaveSummaryRepo;
import com.leavemanagement.LeaveManagement.services.LeaveSummaryService;
//import com.leavemanagement.LeaveManagement.services.LeaveTypeService;


@Service
public class LeaveSummaryServiceImpl implements LeaveSummaryService{
	@Autowired
	private LeaveSummaryRepo leavesummaryrepo;
	
	@Override
	public List<LeaveSummary> getAllLeaveSummaries() {
		// TODO Auto-generated method stub
		return leavesummaryrepo.getAllLeaveSummaries();
	}

}
