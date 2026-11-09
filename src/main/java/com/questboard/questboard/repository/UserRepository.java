package com.questboard.questboard.repository;

import com.questboard.questboard.model.UserGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserGame, Long> {
}