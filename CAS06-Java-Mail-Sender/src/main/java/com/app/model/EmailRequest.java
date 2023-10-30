package com.app.model;

import lombok.Data;

@Data
public class EmailRequest {

	private String email;
    private String time; // You can use a string to represent immediate, delay, or specific date/time.
    private String subject;
    private String body;
	
}
