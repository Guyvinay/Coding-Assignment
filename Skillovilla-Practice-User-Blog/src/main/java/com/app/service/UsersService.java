package com.app.service;

import com.app.modal.Users;

import java.util.List;
import java.util.Map;


public interface UsersService {
    public Users getUserById(String user_id);
    public Users getUserByEmail(String userEmail);
    public List<Users> getAllUsers();
    public Users createUsers(Users user);
    public Users updateUsers(String user_id, Users user);
    public String deleteUsers(String user_id);

    public Map<String, Object> loginUser(String email, String password);

}
