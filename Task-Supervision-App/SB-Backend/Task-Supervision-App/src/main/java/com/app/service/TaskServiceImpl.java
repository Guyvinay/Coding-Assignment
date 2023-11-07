package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.TaskNotFoundException;
import com.app.model.Task;
import com.app.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Task createTask(Task task) {
		if(task==null) throw new TaskNotFoundException("Task Cannot be null");
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks = taskRepository.findAll();
		if(tasks.isEmpty())throw new TaskNotFoundException("Task Store Empty! Not any Task to Show...");
		return tasks;
	}

	@Override
	public Task getTaskById(Long id) {
		Task task = taskRepository.findById(id).orElseThrow(
				()-> new TaskNotFoundException("Task Not Found With id:- "+id)
				);
		return task;
	}

	@Override
	public Task getTaskByTitle(String title) {
		 
		Task task = taskRepository.findByTaskTitle(title).orElseThrow(
				()-> new TaskNotFoundException("Task Not Found With id:- "+title)
				);
		return task;
	}

}
