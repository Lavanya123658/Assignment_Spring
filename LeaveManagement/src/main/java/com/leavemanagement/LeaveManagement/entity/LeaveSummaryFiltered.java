package com.leavemanagement.LeaveManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LeaveSummaryFiltered {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serialNo;

    private String name;
    private int leavesApproved;
    private int leavesPending;
    private int leavesRejected;
}
