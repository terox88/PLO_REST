package com.plo.restplo;

import com.plo.restplo.domain.*;
import com.plo.restplo.exception.BoardNotFoundException;
import com.plo.restplo.exception.GameNotFoundException;
import com.plo.restplo.service.DbService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class DbServiceTest {
    @Autowired
    DbService dbService;
    private Board board;
    private Game game;
    @BeforeEach
    void preparingData() {
        Player player1 = new Player("Player 1", Hero.PASSIONARIA);
        Player player2 =new Player("Player 2", Hero.OLAF);

        ViperGorge viperGorge = new ViperGorge();
        viperGorge.setBlackMarkers(3);
        viperGorge.setRedMarkers(2);
        viperGorge.setGreenMarkers(1);
        viperGorge.setBlueMarkers(4);

        ActionField actionField1 = new ActionField(ActionFieldType.INFLUENCES, 5);
        ActionField actionField2 = new ActionField(ActionFieldType.MOVE, 3);

        Land land1 = new Land(1, new int[]{2, 3}, 2);

        HeroCard heroCard1 = new HeroCard(player1, Hero.PASSIONARIA, new Abilities(), new ArrayList<>(), new ArrayList<>(), 1, 2, 3, 100, 50, 0);
        HeroCard heroCard2 = new HeroCard(player2, Hero.OLAF, new Abilities(), new ArrayList<>(), new ArrayList<>(), 1, 2, 3, 100, 50, 0);

        InitiativeTrack initiativeTrack = new InitiativeTrack(new ArrayList<>());

        List<ActionField> actionFields = Arrays.asList(actionField1, actionField2);
        List<Land> lands = Arrays.asList(land1);
        List<HeroCard> heroCards = Arrays.asList(heroCard1, heroCard2);

      board = new Board(viperGorge, actionFields, lands, heroCards, initiativeTrack, 0, 10);
      Prize mana = new Prize(2);
      Prize gold = new Prize(1);
      Prize population = new Prize(1);
      game = new Game(board, List.of(new LandToken(1, mana, gold, population, 1, 1, 1)));
    }

    @Test
    void shouldSaveBoard() throws BoardNotFoundException {
        //When
        dbService.saveBoard(board);
        //Then
        long id = board.getId();
        Board receivedBoard = dbService.getBoard(id);
        Assertions.assertEquals(Hero.PASSIONARIA, receivedBoard.getHeroCards().get(0).getHero());
        Assertions.assertTrue(id != 0);
        //Clean up
        dbService.deleteBoard(id);

    }

    @Test
    void shouldSaveGame() throws GameNotFoundException {

        //When
        dbService.saveGame(game);
        //Then
        long id = game.getId();
       Game receivedGame = dbService.getGame(id);
        Assertions.assertEquals(Hero.PASSIONARIA, receivedGame.getBoard().getHeroCards().get(0).getHero());
        Assertions.assertTrue(id != 0);
        //Clean up
        dbService.deleteGame(id);


    }
}
