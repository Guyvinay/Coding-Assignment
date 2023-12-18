package com.app.service;

import com.app.modal.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UsersService {
    @Override
    public Users getUserById(String user_id) {
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return null;
    }

    @Override
    public Users createUsers(Users user) {
        return null;
    }

    @Override
    public Users updateUsers(String user_id, Users user) {
        return null;
    }

    @Override
    public String deleteUsers(String user_id) {
        return null;
    }
}
