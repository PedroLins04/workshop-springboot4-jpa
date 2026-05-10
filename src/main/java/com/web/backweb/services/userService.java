package com.web.backweb.services;

import com.web.backweb.entities.User;
import com.web.backweb.repositories.userRepository;
import com.web.backweb.services.Exceptions.ResourceExceptionHandler;
import com.web.backweb.services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
       return obj.orElseThrow(() -> new ResourceNotFoundException(Id));
    }

    public User Insert (User obj) {
        return repository.save(obj);
    }

    public void Delete (Long Id) {
        repository.deleteById(Id);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

    public User Update (Long Id, User obj) {
        User entity = repository.getReferenceById(Id);
        updateData(entity, obj);
        return repository.save(entity);
    }

}
