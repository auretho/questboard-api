package com.questboard.questboard.service;

import com.questboard.questboard.model.Quest;
import com.questboard.questboard.model.UserGame;
import com.questboard.questboard.repository.QuestRepository;
import com.questboard.questboard.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, QuestRepository questRepository) {
        return args -> {
            // Création de l'utilisateur par défaut
            if (userRepository.count() == 0) {
                userRepository.save(new UserGame("Aurélie", 3, 140, 250));
            }

            // Création de quêtes par défaut si la table est vide
            if (questRepository.count() == 0) {
                Quest q1 = new Quest();
                q1.setTitle("Sécuriser l'API avec Spring Security");
                q1.setDescription("Implémenter les filtres et les tokens.");
                q1.setStatus("TODO");
                q1.setDifficulty("HARD");
                q1.setXp(50);
                questRepository.save(q1);

                Quest q2 = new Quest();
                q2.setTitle("Créer le composant Header React");
                q2.setDescription("Afficher le niveau et la barre d'XP.");
                q2.setStatus("DONE");
                q2.setDifficulty("MEDIUM");
                q2.setXp(25);
                questRepository.save(q2);
            }
        };
    }
}