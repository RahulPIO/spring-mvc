package com.example.springmvcpractice.service;

import com.example.springmvcpractice.entity.MatchFormat;
import com.example.springmvcpractice.entity.Player;
import com.example.springmvcpractice.repository.MatchFormatRepository;
import com.example.springmvcpractice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private MatchFormatRepository matchFormatRepository;

    public Player getPlayerById(int id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()) {
            return optionalPlayer.get();
        } else {
            throw new RuntimeException("Player Not Found With given Id" + id);
        }
    }

    public MatchFormat getMatchStatsByFormat(String format, int id) {
        MatchFormat matchFormat = matchFormatRepository.findByFormatAndPlayerId(format, id);
        if (matchFormat != null) {
            return matchFormat;
        } else {
            return new MatchFormat(-1, "NONE", 0, 0, 0, 0);
        }
    }
}
