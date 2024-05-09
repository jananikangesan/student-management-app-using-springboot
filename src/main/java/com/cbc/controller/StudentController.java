package com.cbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.model.Student;
import com.cbc.service.StudentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public String add(@RequestBody Student student) {
		studentService.saveStudent(student);
		return "new student is added"; 
	}
	
	@GetMapping("/getAll")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getStudent/{id}")
	public Student getStudent(@PathVariable int id){
		return studentService.getStudentById(id);
	}
	
	@PutMapping("/update/{id}")
	public String update(@RequestBody Student student,@PathVariable int id) {
		Student updateSt=studentService.updateStudent(student,id);
		
		if(updateSt!=null) {
			return " student is updated";
		}
		return " student record is not found"; 
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}

}
