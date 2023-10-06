package com.logistic.config.dto;

import lombok.Data;

@Data
public class AuthResponse {
	
	private Integer id;
	private String user;
	private String access_token;

}
