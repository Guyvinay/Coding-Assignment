package com.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.modal.Student;
import com.app.modal.StudentNotFoundException;
import com.app.repository.StudentRepository;

@Service
public class StudentServiceImplement implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student addStudent(Student student) {
		student.setAdmission_date(LocalDate.now());
		student.setCurrent_debt(student.getCollege_fee());
		Student save = studentRepository.save(student);
		return save;
	}

	@Override
	public Student getAStudentById(String _id) {
		Student student = studentRepository.findById(_id)
		                 .orElseThrow(
		                		 ()-> new StudentNotFoundException("Student: "+_id+", not Found")
		                		 );
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list = studentRepository.findAll();
		if(list.isEmpty()) throw new StudentNotFoundException("No Student Found!");
		return list;
	}

	@Override
	public Student updateStudent(String _id, Student student) {
		Student found = studentRepository.findById(_id)
                .orElseThrow(
               		 ()-> new StudentNotFoundException("Student: "+_id+", not Found")
               		 );
		found.setEmail(student.getEmail());
		found.setName(student.getName());
		return studentRepository.save(found);
	}

	@Override
	public String deleteStudent(String _id) {
		Student found = studentRepository.findById(_id)
                .orElseThrow(
               		 ()-> new StudentNotFoundException("Student: "+_id+", not Found")
               		 );
		studentRepository.delete(found);
		return "Student: "+_id+", Successfully deleted.";
	}

}
