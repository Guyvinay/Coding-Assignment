package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.exception.RepositoryNotFoundException;
import com.app.modal.Repository;
import com.app.repository.ReposRepository;

@Service
public class RepoServImpl implements RepoService {

	private static String reposUrl = "https://api.github.com/users/";
	
	@Autowired
	private ReposRepository reposRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Repository> getAllRepo(String username) {
		
		ResponseEntity<List<Repository>> responseEntity = restTemplate
				.exchange(
				          reposUrl+username+"/repos", 
				          HttpMethod.GET, 
				          null, 
				          new ParameterizedTypeReference<List<Repository>>(){}
				          );
		
		List<Repository> repos = responseEntity.getBody();
		
		if(!repos.isEmpty()) {
			return repos;
		}
		else throw new RepositoryNotFoundException("Repositories not found");
		
	}

	@Override
	public List<Repository> saveAllRepo(String username) {
		
		ResponseEntity<List<Repository>> responseEntity = restTemplate
				.exchange(
				          reposUrl+username+"/repos", 
				          HttpMethod.GET, 
				          null, 
				          new ParameterizedTypeReference<List<Repository>>(){}
				          );
		
		List<Repository> repos = responseEntity.getBody();
		
		if(!repos.isEmpty()) {
			return reposRepository.saveAll(repos);
		}
		else throw new RepositoryNotFoundException("Repositories not found");
		
	}

	@Override
	public List<Repository> getAllSavedRepo() {
		List<Repository> list = reposRepository.findAll();
		if(list.isEmpty())throw new RepositoryNotFoundException("Repositories not found");
		return list;
	}
	
	@Override
	public Repository getSavedRepoById(String id) {
		 
		return 
			reposRepository.findById(id).orElseThrow(
			() -> new RepositoryNotFoundException("Repositories not found")
			);
	}
}
