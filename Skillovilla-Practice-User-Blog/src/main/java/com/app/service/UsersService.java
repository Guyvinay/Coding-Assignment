package com.app.service;

import com.app.modal.Users;

import java.util.List;


public interface UsersService {
    public Users getUserById(String user_id);
    public List<Users> getAllUsers();
    public Users createUsers(Users user);
    public Users updateUsers(String user_id, Users user);
    public String deleteUsers(String user_id);
}
