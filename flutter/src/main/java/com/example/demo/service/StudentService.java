package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.status.StatusMessage;

@Service
public interface StudentService {
	
	public boolean addStudent(StudentDTO obj)throws Exception;
	public List<StudentDTO> getAllStudent()throws Exception;
//	public StatusMessage authenticate(StudentDTO obj)throws Exception;
	public StudentDTO getStudent(int id) throws Exception;
	public StatusMessage editStudent(StudentDTO obj)throws Exception;
}
