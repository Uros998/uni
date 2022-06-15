package com.metropolitan.it355dz09.controller;

import com.metropolitan.it355dz09.entity.Gameplay;
import com.metropolitan.it355dz09.service.GameplayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gameplays")
@RequiredArgsConstructor
public class GameplayController {

    private final GameplayService gameplayService;

    @GetMapping
    public ResponseEntity<List<Gameplay>> getAllGameplay(){
        return new ResponseEntity<List<Gameplay>>(gameplayService.findAllGameplay(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Gameplay> save(@RequestBody Gameplay gameplay){
        return ResponseEntity.ok(gameplayService.saveGameplay(gameplay));
    }


    @PutMapping
    public ResponseEntity<Gameplay> update(@RequestBody Gameplay gameplay){
        return ResponseEntity.ok(gameplayService.updateGameplay(gameplay));
    }

    @DeleteMapping("/{gameplayId}")
    public void deleteById(@PathVariable Integer gameplayId){
        gameplayService.deleteGameplayById(gameplayId);
    }
}
