package com.web.backweb.services;

import com.web.backweb.entities.Order;
import com.web.backweb.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class orderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long Id) {
        Optional<Order> obj = repository.findById(Id);
        return obj.get();
    }

}
