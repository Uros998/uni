package com.metropolitan.it355dz09.service.impl;

import com.metropolitan.it355dz09.entity.Player;
import com.metropolitan.it355dz09.repository.PlayerRepository;
import com.metropolitan.it355dz09.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public List<Player> findAllPlayers() {
        List<Player> listPlayers = playerRepository.findAll();
        return listPlayers;
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayerById(Integer id) {
        playerRepository.deleteById(id);
    }
}
