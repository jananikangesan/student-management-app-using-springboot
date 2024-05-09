package com.cbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbc.model.Student;
import com.cbc.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
		
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student,int id) {
		Boolean findstudent=studentRepository.existsById(id);
		
		if(findstudent) {
			return studentRepository.save(student);
		}

		return null;
	}

	@Override
	public String deleteStudent(int id) {
		Boolean student=studentRepository.existsById(id);
		if(student) {
			studentRepository.deleteById(id);
			return "student deleted successfully";
		}
		return "no record found";
	}

	@Override
	public Student getStudentById(int id) {
		Student student=studentRepository.findById(id).orElse(null);
		
		return student;
	}
	
	

}
