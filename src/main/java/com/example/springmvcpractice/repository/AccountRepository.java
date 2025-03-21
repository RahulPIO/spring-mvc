package com.example.springmvcpractice.repository;

import com.example.springmvcpractice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
