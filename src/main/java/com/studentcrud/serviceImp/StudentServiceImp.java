package com.studentcrud.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentcrud.Model.Student;
import com.studentcrud.Repository.StudentRepo;
import com.studentcrud.service.StudentService;


@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	public StudentRepo studentrepo;
	
	@Override
	public List<Student> addStudent(Student student) {
		studentrepo.save(student);
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		return (List<Student>) studentrepo.findAll();
	}

	@Override
	public void deleteStudents(int id) {
		studentrepo.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentrepo.findById(id);
	}

	@Override
	public void updateStudent(int id, Student student) {
		
		Student oldStudent=studentrepo.findById(id);
		
		oldStudent.setFirstname(student.getFirstname());
		oldStudent.setLastname(student.getLastname());
		
		studentrepo.save(oldStudent);
		// TODO Auto-generated method stub
		
	}

}
