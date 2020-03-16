package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.status.StatusMessage;

import lombok.extern.slf4j.Slf4j;

@Service("StudentService")
@Slf4j
public class StudentServiceImplementation implements StudentService {
	@Autowired
	StudentRepo repo;
	
	@Autowired
	StudentMapper mapper;
	
	public boolean addStudent(StudentDTO obj)
	{
		try
		{
			Student student=mapper.toStudent(obj);
			Student response=repo.save(student);
			
			if(response!=null)
			{
				return true;
			}
			else {
				return false;
			}
			
		}catch (Exception e) {
			log.error("Error occured while inserting record..."+e.getMessage(),e);
			throw e; 

		}
	}
	
	public List<StudentDTO> getAllStudent() throws Exception
	{
		List<Student> obj=repo.findAll();
		List<StudentDTO> dto=mapper.toStudentDTOList(obj);
		if(dto!=null || !dto.isEmpty())
		{
			return dto;
		}
		else
		{
			return new ArrayList<StudentDTO>();
		}
	}
	
	public StudentDTO getStudent(int id) throws Exception
	{
		Student obj=repo.findById(id).orElse(new Student());
		StudentDTO dto=mapper.toStudentDTO(obj);
		
		return dto;
	}
	
	public StatusMessage editStudent(StudentDTO obj)throws Exception
	{
		Student std=mapper.toStudent(obj);
		StatusMessage result= new StatusMessage();
		Student obj1=repo.save(std);
		
		if( (std==null)) {
			result.setStatus(400);
		}else {
			StudentDTO customerDTO2=mapper.toStudentDTO(std);

			result.setStatus(200);
			result.setMessage(customerDTO2);
		}	
		return result;
	}
	
	
	

}
