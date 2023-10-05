package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.modal.Profile;

public interface ProfileRepository extends JpaRepository<Profile, String>{

}
