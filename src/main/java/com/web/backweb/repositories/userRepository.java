package com.web.backweb.repositories;

import com.web.backweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Long> {

}
