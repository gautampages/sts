package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping(value = "/students")
	public ResponseEntity<List<StudentDTO>> getAllStudents()
	{
		try
		{
			List<StudentDTO> dto=service.getAllStudent();
			if(!dto.isEmpty())
			{
				return ResponseEntity.ok(dto);
			}else {
				log.debug("no employee  found:: ");
				return ResponseEntity.notFound().eTag("no records found").build();

			}
		}catch (Exception exc) {
			log.debug("no employee  found:: "+exc.getMessage());
			return ResponseEntity.notFound().eTag("Record not found").build();

		}
		
	}

}
