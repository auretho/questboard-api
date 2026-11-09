package com.questboard.questboard.controller;

import com.questboard.questboard.model.Quest;
import com.questboard.questboard.model.UserGame;
import com.questboard.questboard.repository.QuestRepository;
import com.questboard.questboard.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") // Autorise ton front-end React à communiquer avec l'API
public class QuestController {

    private final QuestRepository questRepository;
    private final UserRepository userRepository;

    public QuestController(QuestRepository questRepository, UserRepository userRepository) {
        this.questRepository = questRepository;
        this.userRepository = userRepository;
    }

    // 1. Récupérer l'utilisateur (on prend le premier de la liste)
    @GetMapping("/user")
    public UserGame getUser() {
        return userRepository.findAll().stream().findFirst().orElse(null);
    }

    // 2. Mettre à jour l'utilisateur (XP / Niveau)
    @PutMapping("/user")
    public UserGame updateUser(@RequestBody UserGame updatedUser) {
        UserGame user = userRepository.findAll().stream().findFirst().orElseThrow();
        user.setLevel(updatedUser.getLevel());
        user.setCurrentXp(updatedUser.getCurrentXp());
        user.setXpToNextLevel(updatedUser.getXpToNextLevel());
        return userRepository.save(user);
    }

    // 3. Récupérer toutes les quêtes
    @GetMapping("/quests")
    public List<Quest> getAllQuests() {
        return questRepository.findAll();
    }

    // 4. Créer une nouvelle quête
    @PostMapping("/quests")
    public Quest createQuest(@RequestBody Quest quest) {
        return questRepository.save(quest);
    }

    // 5. Mettre à jour une quête (ex: changer son statut)
    @PutMapping("/quests/{id}")
    public Quest updateQuestStatus(@PathVariable Long id, @RequestBody Quest questDetails) {
        Quest quest = questRepository.findById(id).orElseThrow();
        quest.setStatus(questDetails.getStatus());
        return questRepository.save(quest);
    }

    // 6. Supprimer une quête
    @DeleteMapping("/quests/{id}")
    public void deleteQuest(@PathVariable Long id) {
        questRepository.deleteById(id);
    }
}