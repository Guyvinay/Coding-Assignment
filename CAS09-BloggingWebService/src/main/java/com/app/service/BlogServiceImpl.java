package com.app.service;

import com.app.model.Blog;
import com.app.model.Users;
import com.app.repository.BlogRepository;
import com.app.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired private BlogRepository blogRepository;

    @Autowired private UsersRepository usersRepository;

    @Override
    public Map<String, Object> createBlog(Blog blog, String userId) {
        Map<String, Object> map = new HashMap<>();
        Optional<Users> optional = usersRepository.findById(userId);

        if(optional.isEmpty()){
             map.put("msg","User with _id: "+userId+" not found");
             return map;
        }
        blog.setUser(optional.get());
        Blog pBlog = blogRepository.save(blog);
        map.put("blog", pBlog);
        return map;
    }

    @Override
    public Map<String, Object> getBlogById(String _id) {
        return null;
    }

    @Override
    public Map<String, Object> getAllBLogs() {
        Map<String, Object> map = new HashMap<>();

        List<Blog> blogs = blogRepository.findAll();
        System.out.println(blogs);
        if(blogs.isEmpty()){
            map.put("msg", "No BLogs Found");
        }else{
            map.put("Total Blogs", blogs.size());
            map.put("blogs",blogs);
        }
        return map;
    }

    @Override
    public Map<String, Object> deleteBlogById(String _id) {
        return null;
    }
}
