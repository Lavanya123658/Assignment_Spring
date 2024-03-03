package com.leavemanagement.LeaveManagement.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leavemanagement.LeaveManagement.entity.LeaveSummaryFiltered;

@Repository
public interface LeaveSummaryFilteredRepo extends JpaRepository<LeaveSummaryFiltered, Long>{

	@Query(value = "CALL get_leave_summary_filtered(?1, ?2)", nativeQuery = true)
    List<LeaveSummaryFiltered> getLeaveSummaryFiltered(String fromDate, String toDate);
}
