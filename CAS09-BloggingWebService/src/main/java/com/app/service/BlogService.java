package com.app.service;

import java.util.Map;

import com.app.model.Blog;

public interface BlogService {
	
	public Map<String, Object> createBlog(Blog blog, String userId);
	public Map<String, Object> getBlogById(String _id);
	public Map<String, Object> getAllBLogs();
	public Map<String, Object> deleteBlogById(String _id);
}
