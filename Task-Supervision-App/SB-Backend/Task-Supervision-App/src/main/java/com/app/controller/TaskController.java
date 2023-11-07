package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Task;
import com.app.service.TaskService;

/*
 
 
 {
 "taskTitle":"Task One ",
 "taskDesc":"This is Task One",
 "status":"Pending"
 }
 
 */

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping(value = "/createTask")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		return new ResponseEntity<Task>(taskService.createTask(task),HttpStatus.ACCEPTED);
	}
	@GetMapping(value = "/getAllTasks")
	public ResponseEntity<List<Task>> getAllTasks(){
		return new ResponseEntity<List<Task>>(taskService.getAllTasks(),HttpStatus.ACCEPTED);
	}
	@GetMapping(value = "/getTaskById/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
		return new ResponseEntity<Task>(taskService.getTaskById(id),HttpStatus.ACCEPTED);
	}
	@GetMapping(value = "/getTaskByTitle/{title}")
	public ResponseEntity<Task> getTaskByTitle(@PathVariable("title")String title){
		return new ResponseEntity<Task>(taskService.getTaskByTitle(title),HttpStatus.ACCEPTED);
	}

}
