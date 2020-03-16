package com.example.demo.status;

import com.example.demo.dto.StudentDTO;

import lombok.Data;

@Data
public class StatusMessage {

	private int status;
	private StudentDTO message;
}
