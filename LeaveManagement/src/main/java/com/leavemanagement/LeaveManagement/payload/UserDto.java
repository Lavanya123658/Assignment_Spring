package com.leavemanagement.LeaveManagement.payload;

import java.util.Date;

import com.leavemanagement.LeaveManagement.entity.Role;
import com.leavemanagement.LeaveManagement.entity.Users;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
	private int id;
	private String email;
	private String password;
	private String personalEmail;
	private String mobile;
	//private String password;
	private Date dateOfJoining;
	private String name;
	private int managerId;
	
	@Enumerated(EnumType.STRING)
	private Role role;
}
