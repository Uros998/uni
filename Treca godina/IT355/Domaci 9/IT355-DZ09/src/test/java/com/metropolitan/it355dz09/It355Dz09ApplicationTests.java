package com.metropolitan.it355dz09;

import com.metropolitan.it355dz09.entity.Game;
import com.metropolitan.it355dz09.repository.GameRepository;
import com.metropolitan.it355dz09.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
class It355Dz09ApplicationTests {

    @Autowired
    private GameService gameService;

    @MockBean
    private GameRepository gameRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void findAllTest() {
        Game game1 = new Game(1,"Call of Duty", 8);
        Game game2 = new Game(2,"Need for speed", 10);
        Game game3 = new Game(3,"GTA", 7);
        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);
        games.add(game3);

        when(gameRepository.findAll()).thenReturn(games);

        Integer expectedCount = 3;
        System.out.println(gameService.findAllGames());
        assertEquals(expectedCount, gameService.findAllGames().size());
        assertTrue(gameService.findAllGames().contains(game1));
    }

    @Test
    void saveTest() {
        Game game1 = new Game(1,"Call of Duty", 8);

        when(gameRepository.save(game1)).thenReturn(game1);
        System.out.println(game1);
        assertEquals(game1, gameService.saveGame(game1));

    }

    @Test
    void updateTest() {
        Game game1 = new Game(1,"Call of Duty", 8);
        when(gameRepository.save(game1)).thenReturn(game1);

        Game actual = gameService.saveGame(game1);
        assertEquals(game1, actual);
        assertEquals(game1.getName(), actual.getName());
        assertEquals(game1.getRating(), actual.getRating());
    }

    @Test
    public void deleteByIdTest(){
        gameService.deleteGameById(1);
        verify(gameRepository, times(1)).deleteById(1);
    }
}
