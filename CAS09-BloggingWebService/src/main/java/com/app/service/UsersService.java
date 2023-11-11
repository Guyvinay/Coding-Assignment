package com.app.service;
import com.app.model.Users;
import java.util.Map;
public interface UsersService {
    public Map<String, Object> createUser(Users user);
    public Map<String, Object> findUserById(String _id);
    public Map<String, Object> findUsersByEmail(String email);

    public Map<String, Object> findAllUsers();
    public Map<String, Object> deleteUserById(String _id);
}
