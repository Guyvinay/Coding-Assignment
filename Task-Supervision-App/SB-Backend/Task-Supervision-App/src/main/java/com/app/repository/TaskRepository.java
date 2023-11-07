package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	public Optional<Task> findByTaskTitle(String title);
}
