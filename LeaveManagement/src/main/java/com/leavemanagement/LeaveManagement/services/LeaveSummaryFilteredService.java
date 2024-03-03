package com.leavemanagement.LeaveManagement.services;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.leavemanagement.LeaveManagement.entity.LeaveSummaryFiltered;

@Service
public interface LeaveSummaryFilteredService {
	List<LeaveSummaryFiltered> getLeaveSummaryFiltered(String fromDate, String toDate);
}
