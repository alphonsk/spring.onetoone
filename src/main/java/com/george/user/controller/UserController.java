package com.george.user.controller;

import com.george.user.model.User;
import com.george.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        userService.createUser(user);
        return user;
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable final Integer id, @RequestBody User user) {
         return userService.updateUser(id, user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }







}
