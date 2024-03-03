package com.leavemanagement.LeaveManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leavemanagement.LeaveManagement.entity.LeaveSummary;
import com.leavemanagement.LeaveManagement.services.LeaveSummaryService;


@RestController
@RequestMapping("/api/auth")
public class LeaveSummaryController {
	@Autowired
	private LeaveSummaryService leaveSummaryService;
	
	@GetMapping("/leaveSummary")
	public List<LeaveSummary> getAllLeaveSummaries() {
		// TODO Auto-generated method stub
		return leaveSummaryService.getAllLeaveSummaries();
	}

	
}
