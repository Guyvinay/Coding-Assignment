package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.modal.Student;
import com.app.service.StudentService;

/*

{
"name":"Augustus Waters",
"email":"augustus@gmail.com",
"college_name":"College A",
"college_fee":56000
}

*/

@RestController
@RequestMapping(value = "/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping()
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(
				studentService.addStudent(student),
				HttpStatus.ACCEPTED
				);		
	}
	
	@GetMapping(value = "/{_id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("_id")String _id){
		return new ResponseEntity<Student>(
				studentService.getAStudentById(_id),
				HttpStatus.ACCEPTED
				);
				
	}
	
	@GetMapping()
	public ResponseEntity<List<Student>> getAllStudent(){
		return new ResponseEntity<List<Student>>(
				studentService.getAllStudent(),
				HttpStatus.ACCEPTED
				);
	}
	
	@PutMapping(value = "/{_id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("_id")String _id, @RequestBody Student student){
		return new ResponseEntity<Student>(
				studentService.updateStudent(_id, student),
				HttpStatus.ACCEPTED
				);
	}
	@DeleteMapping(value = "/{_id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("_id")String _id){
		return new ResponseEntity<String>(
				studentService.deleteStudent(_id),
				HttpStatus.ACCEPTED
				);
	}
	
	
}
