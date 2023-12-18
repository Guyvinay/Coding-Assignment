package com.app.service;

import com.app.modal.Blog;

import java.util.List;

public interface BlogService {

    public Blog getBlogById(String blog_id);
    public List<Blog> getAllBlogs(String blog_id);
    public List<Blog> getAllBlogByUserId(String user_id);
    public Blog createBlog(String user_id, Blog blog);
    public Blog updateBlog(String user_id, Blog blog);
    public Blog deleteBlog(String blog_id);

}
