package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Emails;

public interface EmailRepository extends JpaRepository<Emails, Long> {

}
