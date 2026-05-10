package com.web.backweb.services;

import com.web.backweb.entities.User;
import com.web.backweb.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService {

    @Autowired
    private userRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long Id) {
       Optional<User> obj = repository.findById(Id);
       return obj.get();
    }

    public User Insert (User obj) {
        return repository.save(obj);
    }

    public void Delete (Long Id) {
        repository.deleteById(Id);
    }

}
