package com.example.springmvcpractice.repository;

import com.example.springmvcpractice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
}
