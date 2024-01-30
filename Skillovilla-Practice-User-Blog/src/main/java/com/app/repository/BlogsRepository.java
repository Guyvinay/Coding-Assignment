package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.modal.Blog;

public interface BlogsRepository extends JpaRepository<Blog, String> {

}
