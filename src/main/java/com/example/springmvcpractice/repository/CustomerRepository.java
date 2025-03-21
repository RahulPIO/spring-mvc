package com.example.springmvcpractice.repository;

import com.example.springmvcpractice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

