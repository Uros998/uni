package com.metropolitan.it355dz09.controller;

import com.metropolitan.it355dz09.entity.Game;
import com.metropolitan.it355dz09.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(){
        return new ResponseEntity<List<Game>>(gameService.findAllGames(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Game> save(@RequestBody Game game){
        return ResponseEntity.ok(gameService.saveGame(game));
    }


    @PutMapping
    public ResponseEntity<Game> update(@RequestBody Game game){
        return ResponseEntity.ok(gameService.update(game));
    }

    @DeleteMapping("/{gameId}")
    public void deleteById(@PathVariable Integer gameId){
        gameService.deleteGameById(gameId);
    }
}
