package com.web.backweb.services;

import com.web.backweb.entities.Product;
import com.web.backweb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long Id) {
       Optional<Product> obj = repository.findById(Id);
       return obj.get();
    }

}
