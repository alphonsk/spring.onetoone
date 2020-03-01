package com.george.user.service;

import com.george.user.model.User;
import com.george.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User updateUser(Integer id, User user) {
        Optional<User> userOp = getUser(id);
        User myUser = userOp.get();
        myUser.setName(user.getName());
        userRepository.save(myUser);
        return myUser;
    }

    public User deleteUser(Integer id) {
        Optional<User> userOp = getUser(id);
        User myUser = userOp.get();
        userRepository.delete(myUser);
        return myUser;
    }

    //END
}
