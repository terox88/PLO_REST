package com.plo.restplo;

import com.plo.restplo.domain.*;
import com.plo.restplo.factory.GameFactory;
import com.plo.restplo.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class InitiativeTrackTest {
    @Autowired
    GameService gameService;
    @Autowired
    GameFactory gameFactory;
    @Test
    void settingOrderTest() {
        //Given
        Player player1 = new Player("Player 1", Hero.PASSIONARIA);
        Player player2 =new Player("Player 2", Hero.OLAF);

        ViperGorge viperGorge = new ViperGorge();
        viperGorge.setBlackMarkers(3);
        viperGorge.setRedMarkers(2);
        viperGorge.setGreenMarkers(1);
        viperGorge.setBlueMarkers(4);

        // ActionField

        ActionField actionField1 = new ActionField(ActionFieldType.INFLUENCES, 5);
        ActionField actionField2 = new ActionField(ActionFieldType.MOVE, 3);
        // Lands

        Land land1 = new Land(1, new int[]{2, 3}, 2);

        // HeroCards
        HeroCard heroCard1 = new HeroCard(player1, Hero.PASSIONARIA, new Abilities(), new ArrayList<>(), new ArrayList<>(), 1, 2, 3, 100, 50, 0);
        HeroCard heroCard2 = new HeroCard(player2, Hero.OLAF, new Abilities(), new ArrayList<>(), new ArrayList<>(), 1, 2, 3, 100, 50, 0);

        // InitiativeTrack
        Stage stage = new Stage(1, 3);
        stage.getRounds().add(new Round(1, false, 3,stage));
        InitiativeTrack initiativeTrack = new InitiativeTrack(List.of(stage));


        List<ActionField> actionFields = Arrays.asList(actionField1, actionField2);
        List<Land> lands = Arrays.asList(land1);
        List<HeroCard> heroCards = Arrays.asList(heroCard1, heroCard2);

        Board board = new Board(viperGorge, actionFields, lands, heroCards, initiativeTrack, 0, 10);
        List<Hero> heroes = List.of(player1.getHero(), player2.getHero());
        Game game = new Game(board, List.of(new LandToken()));

        //When
        Game resultGame = gameService.playersOrderSetting(game, heroes);

        //Then
        InitiativeMarker firstMarker = game.getBoard().getInitiativeTrack().getStages().getFirst().getRounds().getFirst().getMarkers().getLast();
        Assertions.assertEquals(Color.GREEN, firstMarker.getColor());
    }


}
