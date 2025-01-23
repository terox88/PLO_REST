package com.plo.restplo;

import com.plo.restplo.domain.*;
import com.plo.restplo.validation.GameValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class GameValidatorTest {
    @Autowired
    GameValidator gameValidator;

    @Test
    void firstInfluenceDoneTrueTest() {
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
        Land land2 = new Land(2, new int[]{1, 3, 4}, 1);
        Land land3 = new Land(3, new int[]{4, 5, 6}, 1);

        // HeroCards
        HeroCard heroCard1 = new HeroCard(player1, Hero.PASSIONARIA, new Abilities(), new ArrayList<>(), new ArrayList<>(), 1, 2, 3, 100, 50, 0);
        HeroCard heroCard2 = new HeroCard(player2, Hero.OLAF, new Abilities(), new ArrayList<>(), new ArrayList<>(), 1, 2, 3, 100, 50, 0);

        // InitiativeTrack
        InitiativeTrack initiativeTrack = new InitiativeTrack();


        List<ActionField> actionFields = Arrays.asList(actionField1, actionField2);
        List<Land> lands = Arrays.asList(land1, land2, land3);
        List<HeroCard> heroCards = Arrays.asList(heroCard1, heroCard2);

        Board board = new Board(viperGorge, actionFields, lands, heroCards, initiativeTrack, 0, 10);
        board.getLands().get(0).getInfluenceMarkers().add(new InfluenceMarker(Color.GREEN));
        board.getLands().get(0).getInfluenceMarkers().add(new InfluenceMarker(Color.BLUE));
        board.getLands().get(1).getInfluenceMarkers().add(new InfluenceMarker(Color.BLUE));
        board.getLands().get(2).getInfluenceMarkers().add(new InfluenceMarker(Color.GREEN));

        //When
        boolean result = gameValidator.isFirstInfluenceDone(board);

        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void firstInfluenceDoneFalseTest() {
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
        Land land2 = new Land(2, new int[]{1, 3, 4}, 1);
        Land land3 = new Land(3, new int[]{4, 5, 6}, 1);

        // HeroCards
        HeroCard heroCard1 = new HeroCard(player1, Hero.PASSIONARIA, new Abilities(), new ArrayList<>(), new ArrayList<>(), 1, 2, 3, 100, 50, 0);
        HeroCard heroCard2 = new HeroCard(player2, Hero.OLAF, new Abilities(), new ArrayList<>(), new ArrayList<>(), 1, 2, 3, 100, 50, 0);

        // InitiativeTrack
        InitiativeTrack initiativeTrack = new InitiativeTrack();


        List<ActionField> actionFields = Arrays.asList(actionField1, actionField2);
        List<Land> lands = Arrays.asList(land1, land2, land3);
        List<HeroCard> heroCards = Arrays.asList(heroCard1, heroCard2);

        Board board = new Board(viperGorge, actionFields, lands, heroCards, initiativeTrack, 0, 10);
        board.getLands().get(0).getInfluenceMarkers().add(new InfluenceMarker(Color.GREEN));
        board.getLands().get(0).getInfluenceMarkers().add(new InfluenceMarker(Color.BLUE));
        board.getLands().get(1).getInfluenceMarkers().add(new InfluenceMarker(Color.BLUE));


        //When
        boolean result = gameValidator.isFirstInfluenceDone(board);

        //Then
        Assertions.assertFalse(result);
    }
}
