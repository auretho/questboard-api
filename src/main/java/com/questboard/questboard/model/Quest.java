package com.questboard.questboard.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quest")
@Getter @Setter @NoArgsConstructor
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    
    @Column(length = 1000)
    private String description;
    
    private String status; // TODO, IN_PROGRESS, DONE
    private String difficulty; // EASY, MEDIUM, HARD
    private int xp;
}