package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	public Optional<Profile> findByEmail(String email);

}
