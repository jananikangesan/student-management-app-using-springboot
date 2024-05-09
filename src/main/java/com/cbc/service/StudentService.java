package com.cbc.service;

import java.util.List;

import com.cbc.model.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public Student getStudentById(int id);
	
	public Student updateStudent(Student student,int id);
	
	public String deleteStudent(int id);
	
}
