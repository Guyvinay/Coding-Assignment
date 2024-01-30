package com.app.service;

import com.app.modal.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Override
    public Blog createBlog(String user_id, Blog blog) {
        return null;
    }

    @Override
    public Blog getBlogById(String blog_id) {
        return null;
    }

    @Override
    public List<Blog> getAllBlogs(String blog_id) {
        return null;
    }

    @Override
    public List<Blog> getAllBlogByUserId(String user_id) {
        return null;
    }



    @Override
    public Blog updateBlog(String user_id, Blog blog) {
        return null;
    }

    @Override
    public Blog deleteBlog(String blog_id) {
        return null;
    }
}
