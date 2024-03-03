package com.leavemanagement.LeaveManagement.entity;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
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
public class LeaveSummary {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long serial_no;

	    private String name;
	   
	    private int leavesApproved;
	    private int leavesPending;
	    private int leavesRejected;
	    private int leavesRemaining;
}
