package com.app.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Task updateTask(Task task) {

		Long id = task.getId();
		
		Task perTask = taskRepository.findById(id).orElseThrow(
				()-> new TaskNotFoundException("Task Not Found With id:- "+id)
				);
		if(task.getStatus()!=null)
		    perTask.setStatus(task.getStatus());
		
		if(task.getTaskTitle()!=null)
			perTask.setTaskTitle(task.getTaskTitle());
		
		if(task.getTaskDesc()!=null)
			perTask.setTaskDesc(task.getTaskDesc());
		
		return taskRepository.save(perTask);
	}

	@Override
	public String deleteTask(Long id){
		
		Task task = taskRepository.findById(id).orElseThrow(
				()-> new TaskNotFoundException("Task Not Found With id:- "+id)
				);
		taskRepository.delete(task);
		
		return "Task:- "+task.getTaskTitle()+" Deleted!";
	}

}
