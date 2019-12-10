package com.stackroute.service;


import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveNewUser(User user) {
        User saveNewUser = userRepository.save(user);
        return saveNewUser;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUserById(int id) {
       userRepository.deleteById(id);
    }
    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public User updateUser(User user, Integer id) {
       // return userRepository.updateUser(user.getName(),Integer id);
        return null;
    }
/*
   @Override
    public User updateUser(User user Integer id) {
       return userRepository.updateUser(user.getName(), Integer id);
    }*/
}
