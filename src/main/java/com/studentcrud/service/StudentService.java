package com.studentcrud.service;

import java.util.List;

import com.studentcrud.Model.Student;

public interface StudentService {

	public List<Student> addStudent(Student student);
	public List<Student> getAllStudents();
	public void deleteStudents(int id);
	public Student getStudentById(int id);
	public  void updateStudent(int id,Student student);

}
