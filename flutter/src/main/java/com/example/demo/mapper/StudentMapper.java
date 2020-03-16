package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
	
	Student toStudent(StudentDTO obj);
	StudentDTO toStudentDTO(Student obj);
	List<StudentDTO> toStudentDTOList(List<Student> studentList);

}
