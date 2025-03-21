package com.example.springmvcpractice.entity;

import javax.persistence.*;

@Entity
public class MatchFormat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String format;
    private int matches;
    private int runsScored;
    private int strikeRate;
    private int average;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="playerId",referencedColumnName = "id")
    private Player player;
    public MatchFormat() {
    }

    public MatchFormat(int id, String format, int matches, int runsScored, int strikeRate, int average) {
        this.id = id;
        this.format = format;
        this.matches = matches;
        this.runsScored = runsScored;
        this.strikeRate = strikeRate;
        this.average = average;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(int strikeRate) {
        this.strikeRate = strikeRate;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
