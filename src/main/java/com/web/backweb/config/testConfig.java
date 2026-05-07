package com.web.backweb.config;

import com.web.backweb.entities.Category;
import com.web.backweb.entities.Order;
import com.web.backweb.entities.Product;
import com.web.backweb.entities.User;
import com.web.backweb.entities.enums.OrderStatus;
import com.web.backweb.repositories.CategoryRepository;
import com.web.backweb.repositories.OrderRepository;
import com.web.backweb.repositories.ProductRepository;
import com.web.backweb.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private userRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Hobbit", "Bilbo and his adventures in a magical world.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Fun and commodity with ultra quality resolution.", 2190.0, "");
        Product p3 = new Product(null, "MacBook Pro", "The environment for your productivity.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Play an experience as you never did.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "A reference for the rest of us.", 100.99, "");

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "97777777", "123");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "98888888", "456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
