package com.metropolitan.it355dz09.service.impl;

import com.metropolitan.it355dz09.entity.Game;
import com.metropolitan.it355dz09.repository.GameRepository;
import com.metropolitan.it355dz09.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Override
    public List<Game> findAllGames() {
        List<Game> listGames = gameRepository.findAll();
        return listGames;
    }

    @Override
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game update(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void deleteGameById(Integer id) {
        gameRepository.deleteById(id);
    }
}
