package com.filters.demo.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filters.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
