package com.app.service;

import java.util.List;

import com.app.modal.Repository;

public interface RepoService {

	public List<Repository> getAllRepo(String username);
	public List<Repository> saveAllRepo(String username);
	public List<Repository> getAllSavedRepo();
	public Repository getSavedRepoById(String id);
}
