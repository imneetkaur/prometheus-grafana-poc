package com.stackroute.service;

import com.stackroute.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public User saveNewUser(User user);
    public List<User> getAllUsers();
    public Optional<User> findUserById(int id);
    public void deleteUserById(int id);
    public void deleteAllUsers();
    public User updateUser(User user,Integer id);
}
