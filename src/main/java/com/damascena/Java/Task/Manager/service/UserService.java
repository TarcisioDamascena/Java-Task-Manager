package com.damascena.Java.Task.Manager.service;

import com.damascena.Java.Task.Manager.model.User;
import com.damascena.Java.Task.Manager.repository.UserRepository;
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

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updateUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updateUser.getUsername());
            user.setPassword(updateUser.getPassword());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found."));
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)){
            throw new RuntimeException("User not found.");
        }
        userRepository.deleteById(id);
    }
}
