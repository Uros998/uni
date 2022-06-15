package com.metropolitan.it355dz09.service;

import com.metropolitan.it355dz09.entity.Game;

import java.util.List;

public interface GameService {
    List<Game> findAllGames();
    Game saveGame(Game game);
    Game update(Game game);
    void deleteGameById(Integer id);
}
