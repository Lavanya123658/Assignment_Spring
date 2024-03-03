package com.leavemanagement.LeaveManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class LeaveNotFoundException extends RuntimeException {
//	logger.info("In manager Exception");
	private String message;
    public LeaveNotFoundException(String message) {
        super(message);
        this.message=message;
        
        
       
    }
}
