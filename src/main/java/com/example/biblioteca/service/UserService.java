package com.example.biblioteca.service;

import com.example.biblioteca.model.User;
import com.example.biblioteca.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}