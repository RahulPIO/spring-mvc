package com.example.springmvcpractice.controller;

import com.example.springmvcpractice.entity.MatchFormat;
import com.example.springmvcpractice.entity.Player;
import com.example.springmvcpractice.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/{id}")
    public String getPlayer(@PathVariable("id") int id, Model model) {
        Player player = null;
        try {
            player = playerService.getPlayerById(id);
            model.addAttribute("player", player);
        } catch (RuntimeException e) {
            model.addAttribute("player", new Player(-1, "None", -1));
            model.addAttribute("message", e.getMessage());
        } catch (Exception e) {
            model.addAttribute("player", new Player(-1, "None", -1));
            model.addAttribute("message", e.getMessage());
        }
        return "player-details";
    }

    @GetMapping("/stats/{id}")
    public String getStats(@PathVariable("id") int id, @RequestParam("format") String format, Model model) {
        MatchFormat matchFormat = playerService.getMatchStatsByFormat(format, id);
        model.addAttribute("matchStats", matchFormat);
        if (matchFormat.getId() == -1) {
            model.addAttribute("message", "Player Not Played this format yet");
        }
        return "stats";
    }
}
