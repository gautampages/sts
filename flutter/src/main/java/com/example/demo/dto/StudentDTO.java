package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDTO {
	private int id;
	private String email;
	private String password;
	private String name;
	private String city;
	private String state;
	


}
