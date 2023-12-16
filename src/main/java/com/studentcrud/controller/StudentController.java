package com.studentcrud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentcrud.Model.Student;
import com.studentcrud.service.StudentService;

@RestController("/rest")
public class StudentController {
	
	@Autowired
	public StudentService studentservice;
	
	@PostMapping("/addstudent")
	public List<Student> addStudent(@RequestBody Student student) {
		List<Student>  studentList = new ArrayList<Student>();
		studentservice.addStudent(student);
		return studentservice.getAllStudents();
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() {
		return studentservice.getAllStudents();
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public List<Student> studentStudent(@PathVariable int id) {
		
		studentservice.deleteStudents(id);
		return studentservice.getAllStudents();
	}
	
	@PutMapping("/updateStudent/{id}")
	public List<Student> updateStudent(@PathVariable int id,@RequestBody Student student) {
		studentservice.updateStudent(id, student);
		return studentservice.getAllStudents();
		
	}
	
	
	
	
	
	
	
	
	

}
