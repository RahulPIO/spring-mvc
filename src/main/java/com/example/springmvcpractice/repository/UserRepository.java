package com.example.springmvcpractice.repository;

import com.example.springmvcpractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
