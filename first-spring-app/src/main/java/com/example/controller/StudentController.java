package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.response.StudentResponse;
import com.example.service.StudentService;
import com.example.entity.Student;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
	
	
	@Value("${app.name : Demo App}")
	private String appName;
	
	@Autowired
	StudentService studentService;
	
	
	@GetMapping("/getAll")
	public List<StudentResponse> getAllStudents() {
		
		List<Student> studentList = studentService.getAllStudents();
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
}
