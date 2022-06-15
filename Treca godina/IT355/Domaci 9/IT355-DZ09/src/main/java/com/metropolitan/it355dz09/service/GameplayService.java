package com.metropolitan.it355dz09.service;


import com.metropolitan.it355dz09.entity.Gameplay;

import java.util.List;

public interface GameplayService {
    List<Gameplay> findAllGameplay();
    Gameplay saveGameplay(Gameplay gameplay);
    Gameplay updateGameplay(Gameplay gameplay);
    void deleteGameplayById(Integer id);
}
