package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.modal.Repository;

public interface ReposRepository extends JpaRepository<Repository, String> {

}
