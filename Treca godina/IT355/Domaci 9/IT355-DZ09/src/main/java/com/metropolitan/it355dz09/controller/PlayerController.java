package com.metropolitan.it355dz09.controller;

import com.metropolitan.it355dz09.entity.Game;
import com.metropolitan.it355dz09.entity.Player;
import com.metropolitan.it355dz09.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        return new ResponseEntity<List<Player>>(playerService.findAllPlayers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Player> save(@RequestBody Player player){
        return ResponseEntity.ok(playerService.savePlayer(player));
    }


    @PutMapping
    public ResponseEntity<Player> update(@RequestBody Player player){
        return ResponseEntity.ok(playerService.updatePlayer(player));
    }

    @DeleteMapping("/{playerId}")
    public void deleteById(@PathVariable Integer playerId){
        playerService.deletePlayerById(playerId);
    }
}
