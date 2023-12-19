package com.app.service;

import java.util.List;

import com.app.modal.Student;

public interface StudentService {
	
	public Student addStudent(Student student);
	public Student getAStudentById(String _id);
	public List<Student> getAllStudent();
	public Student updateStudent(String _id, Student student);
	public String deleteStudent(String _id);

}
