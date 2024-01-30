package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.modal.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, String> {
    Optional<Users> findByEmail(String email);
}
