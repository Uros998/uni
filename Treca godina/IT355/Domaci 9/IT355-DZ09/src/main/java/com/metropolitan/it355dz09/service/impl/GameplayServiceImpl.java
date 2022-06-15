package com.metropolitan.it355dz09.service.impl;

import com.metropolitan.it355dz09.entity.Gameplay;
import com.metropolitan.it355dz09.repository.GameplayRepository;
import com.metropolitan.it355dz09.service.GameplayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameplayServiceImpl implements GameplayService {

    private final GameplayRepository gameplayRepository;

    @Override
    public List<Gameplay> findAllGameplay() {
        List<Gameplay> listGameplays = gameplayRepository.findAll();
        return listGameplays;
    }

    @Override
    public Gameplay saveGameplay(Gameplay gameplay) {
        return gameplayRepository.save(gameplay);
    }

    @Override
    public Gameplay updateGameplay(Gameplay gameplay) {
        return gameplayRepository.save(gameplay);
    }

    @Override
    public void deleteGameplayById(Integer id) {
        gameplayRepository.deleteById(id);
    }
}
