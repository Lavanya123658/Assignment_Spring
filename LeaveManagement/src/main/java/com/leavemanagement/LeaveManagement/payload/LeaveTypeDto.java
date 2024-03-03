package com.leavemanagement.LeaveManagement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeaveTypeDto {
	//private Long id;
    private String name;
    private int maxLeaves;
}
