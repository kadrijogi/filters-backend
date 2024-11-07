package com.filters.demo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filters.demo.DAL.UserRepository;
import com.filters.demo.model.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get a user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
/*
    // Update an existing user
    @Transactional
    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setPassword(userDetails.getPassword());
            return userRepository.save(existingUser);
        });
    }

    */

    // Delete a user by ID
    @Transactional
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
