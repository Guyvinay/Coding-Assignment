package com.app.service;

import java.util.List;

import com.app.model.Task;

public interface TaskService {

	public Task createTask(Task task);
	public List<Task> getAllTasks();
	public Task getTaskById(Long id);
	public Task getTaskByTitle(String title);
	public Task updateTask(Task task);
	public String deleteTask(Long id);
}
