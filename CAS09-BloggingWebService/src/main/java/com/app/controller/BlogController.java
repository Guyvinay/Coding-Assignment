package com.app.controller;

import com.app.model.Blog;
import com.app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "api/blogs")
public class BlogController {
    @Autowired private BlogService blogService;

    @PostMapping(value = "/createBlog/{userId}")
    public ResponseEntity<Map<String, Object>> createBlog(@RequestBody Blog blog, @PathVariable("userId")String userId){
        return new ResponseEntity<>(blogService.createBlog(blog,userId), HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/getBlogById/{_id}")
    public ResponseEntity<Map<String, Object>> getBlogById(@PathVariable("_id")String _id){
        return new ResponseEntity<>(blogService.getBlogById(_id), HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/getAllBlogs")
    public ResponseEntity<Map<String, Object>> getAllBlogs(){
        return new ResponseEntity<Map<String, Object>>(blogService.getAllBLogs(), HttpStatus.ACCEPTED);
    }
}
