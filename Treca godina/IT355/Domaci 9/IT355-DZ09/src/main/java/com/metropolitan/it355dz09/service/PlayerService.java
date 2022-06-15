package com.metropolitan.it355dz09.service;

import com.metropolitan.it355dz09.entity.Player;

import java.util.List;

public interface PlayerService {
    List<Player> findAllPlayers();
    Player savePlayer(Player player);
    Player updatePlayer(Player player);
    void deletePlayerById(Integer id);
}
