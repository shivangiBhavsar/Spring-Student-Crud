package com.studentcrud.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentcrud.Model.Student;
@Repository
public interface StudentRepo extends CrudRepository<Student, Integer>{
	
	//public List<Student> addStudent(Student student);
	
	Student save(Student student);
	List<Student> findAll();
	Student findById(int id);

}
