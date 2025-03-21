package com.example.springmvcpractice.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int jerseyNumber;
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<MatchFormat> matchFormat;

    public Player() {
    }

    public Player(int id, String name, int jerseyNumber) {
        this.id = id;
        this.name = name;
        this.jerseyNumber = jerseyNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public List<MatchFormat> getMatchFormat() {
        return matchFormat;
    }

    public void setMatchFormat(List<MatchFormat> matchFormat) {
        this.matchFormat = matchFormat;
    }
}
