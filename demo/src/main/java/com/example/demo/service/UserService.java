package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    public void deleteUser(Long id);

    public void updateUser(User user);

    public List<User> getUsersList();

    public User getById(Long id);
}
