package com.leavemanagement.LeaveManagement.serviceImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagement.LeaveManagement.entity.LeaveSummaryFiltered;
import com.leavemanagement.LeaveManagement.repository.LeaveSummaryFilteredRepo;
import com.leavemanagement.LeaveManagement.services.LeaveSummaryFilteredService;

@Service
public class LeaveSummaryFilteredServiceImpl implements LeaveSummaryFilteredService{
	@Autowired
	private LeaveSummaryFilteredRepo leaverepo;
	
	@Override
	public List<LeaveSummaryFiltered> getLeaveSummaryFiltered(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return leaverepo.getLeaveSummaryFiltered(fromDate, toDate);
	}

}
