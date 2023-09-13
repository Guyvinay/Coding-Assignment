package com.app.appRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.modal.Entities;

public interface AppRepository extends JpaRepository<Entities, String> {

}
