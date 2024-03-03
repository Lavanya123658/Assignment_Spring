package com.leavemanagement.LeaveManagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leavemanagement.LeaveManagement.entity.LeaveSummary;

@Service
public interface LeaveSummaryService {
	List<LeaveSummary> getAllLeaveSummaries();
}
