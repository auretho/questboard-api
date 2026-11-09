package com.questboard.questboard.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_user")
@Getter @Setter @NoArgsConstructor
public class UserGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int level;
    private int currentXp;
    private int xpToNextLevel;

    public UserGame(String name, int level, int currentXp, int xpToNextLevel) {
        this.name = name;
        this.level = level;
        this.currentXp = currentXp;
        this.xpToNextLevel = xpToNextLevel;
    }
}