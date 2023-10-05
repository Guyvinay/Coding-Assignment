package com.app.service;

import com.app.modal.Profile;

public interface ProfileService {

	public Profile getProfile(String username);
	public Profile saveProfile(String username);
	public Profile getSavedProfile(String id);
	public Profile getAllSavedProfile();
}
