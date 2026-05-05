package com.web.backweb.config;

import com.web.backweb.entities.User;
import com.web.backweb.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

    @Autowired
    private userRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "97777777", "123");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "98888888", "456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
