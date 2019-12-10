package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String hello(){
        return "hi the app is up";
    }
    
    @PostMapping("/user")
    public ResponseEntity<?> saveNewUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        userService.saveNewUser(user);
        responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity<List<User>>((List<User>) userService.getAllUsers(), HttpStatus.FOUND);
        return responseEntity;
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUserById(@PathVariable("id") int id){
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity(userService.findUserById(id), HttpStatus.FOUND);
        return responseEntity;
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") int id){
        ResponseEntity responseEntity;
        userService.deleteUserById(id);
        responseEntity= new ResponseEntity("Successfully deleted",HttpStatus.GONE);
        return responseEntity;
    }
    @DeleteMapping("/users")
    public ResponseEntity<?> deleteAllUsers(){
        ResponseEntity responseEntity;
        userService.deleteAllUsers();
        responseEntity=new ResponseEntity("Successfully Deleted all Users",HttpStatus.GONE);
        return responseEntity;
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") int id){
        ResponseEntity responseEntity;
        responseEntity=new ResponseEntity(updateUser(id),HttpStatus.OK);
        return responseEntity;
    }
}
