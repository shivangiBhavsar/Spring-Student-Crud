package com.studentcrud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.studentcrud.Model.Document;
import com.studentcrud.Model.Student;
import com.studentcrud.service.DocumentService;
import com.studentcrud.service.StudentService;

@Controller
@RequestMapping("/jsp")
public class StudentJspController {

	@Autowired
	public StudentService studentservice;

	@Autowired
	public DocumentService documentservice;

	@GetMapping("/addstudentjsp")
	public ModelAndView addStudent() {
		ModelAndView mav = new ModelAndView("addstudent");

		Map<Integer, String> standards = new HashMap<>();
		standards.put(1, "Class 1");
		standards.put(2, "Class 2");
		standards.put(3, "Class 3");
		standards.put(4, "Class 4");
		standards.put(5, "Class 5");
		standards.put(6, "Class 6");
		standards.put(7, "Class 7");
		standards.put(8, "Class 8");
		standards.put(9, "Class 9");
		standards.put(10, "Class 10");
		standards.put(11, "Class 11");
		standards.put(12, "Class 12");

		mav.addObject("student", new Student());
		mav.addObject("standards", standards);
		return mav;
	}

	@GetMapping("/getsinglestudentjsp/{id}")
	public ModelAndView getsinglestudent(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("updatestudent");
		Student student = studentservice.getStudentById(id);
		Map<Integer, String> standards = new HashMap<>();
		standards.put(1, "Class 1");
		standards.put(2, "Class 2");
		standards.put(3, "Class 3");
		standards.put(4, "Class 4");
		standards.put(5, "Class 5");
		standards.put(6, "Class 6");
		standards.put(7, "Class 7");
		standards.put(8, "Class 8");
		standards.put(9, "Class 9");
		standards.put(10, "Class 10");
		standards.put(11, "Class 11");
		standards.put(12, "Class 12");

		mav.addObject("standards", standards);
		mav.addObject("student", student);
		return mav;
	}

	@PostMapping("/savestudentjsp")
	public String saveStudent(@ModelAttribute Student student, @RequestParam("file") MultipartFile file) {
		
		if(student.getId()!=0) {
			if (file.getSize() > 0) {
				Document doc = documentservice.saveDoc(file);
				student.setDocument(doc);
			}else {
			student.setDocument(studentservice.getStudentById(student.getId()).getDocument());
			}
		}
		studentservice.addStudent(student);
		return "redirect:/jsp/getAllStudentsjsp";
	}

	@GetMapping("/getAllStudentsjsp")
	public ModelAndView getAllStudents() {
		ModelAndView mav = new ModelAndView("studentslist");
		mav.addObject("students", studentservice.getAllStudents());
		return mav;
	}

	@GetMapping("/deleteStudentjsp/{id}")
	public String studentStudent(@PathVariable int id) {
		studentservice.deleteStudents(id);
		return "redirect:/jsp/getAllStudentsjsp";
	}

	@PostMapping("/updateStudentjsp")
	public String updateStudent(@RequestParam(name = "id") int id, @RequestBody Student student,
			@RequestParam("file") MultipartFile file) {
		Document doc = documentservice.saveDoc(file);
		student.setDocument(doc);
		studentservice.updateStudent(id, student);
		return "redirect:/jsp/getAllStudentsjsp";

	}

	@GetMapping("/download/{id}")
	public ResponseEntity downloadFileFromLocal(@PathVariable int id) {

		Student student = studentservice.getStudentById(id);

		byte[] data = student.document.getStudentimage();
		ByteArrayResource resource = new ByteArrayResource(data);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + student.getDocument().filename)
				.contentType(MediaType.APPLICATION_PDF).contentLength(data.length).body(resource);
	}

}
