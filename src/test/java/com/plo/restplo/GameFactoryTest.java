package com.plo.restplo;

import com.plo.restplo.domain.*;
import com.plo.restplo.factory.BoardFactory;
import com.plo.restplo.factory.GameFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameFactoryTest {
    @InjectMocks
    private GameFactory gameFactory;
    @Mock
    private BoardFactory boardFactory;

    @Test
    void twoPlayersLandTokenCreatorTest() {

        //When
        List<LandToken> result = gameFactory.landTokenCreator(2);

        //Then
        Assertions.assertEquals(6, result.size());
    }

    @Test
    void threePlayersLandTokenCreatorTest() {

        //When
        List<LandToken> result = gameFactory.landTokenCreator(3);

        //Then
        Assertions.assertEquals(7, result.size());
    }

    @Test
    void fourPlayersLandTokenCreatorTest() {

        //When
        List<LandToken> result = gameFactory.landTokenCreator(4);

        //Then
        Assertions.assertEquals(8, result.size());
    }
   @Test
    void twoPlayersCorrectDataTest () {

       //When
       List<LandToken> result = gameFactory.landTokenCreator(2);

       //Then
       Assertions.assertEquals(1, result.get(0).getOrder());
       Assertions.assertEquals(0, result.get(0).getManaPrize().getQuantity());
       Assertions.assertEquals(1, result.get(0).getGoldPrize().getQuantity());
       Assertions.assertEquals(1, result.get(0).getPopulationPrize().getQuantity());
       Assertions.assertEquals(5, result.get(4).getOrder());
       Assertions.assertEquals(0, result.get(4).getManaPrize().getQuantity());
       Assertions.assertEquals(2, result.get(4).getGoldPrize().getQuantity());
       Assertions.assertEquals(1, result.get(4).getPopulationPrize().getQuantity());

    }

    @Test
    void gameFactoryTestforTwo () {
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
        HeroCard heroCard1 = new HeroCard(player1, Hero.PASSIONARIA, new Abilities(), new ArrayDeque<>(), new ArrayDeque<>(), 1, 2, 3, 100, 50, 0);
        HeroCard heroCard2 = new HeroCard(player2, Hero.OLAF, new Abilities(), new ArrayDeque<>(), new ArrayDeque<>(), 1, 2, 3, 100, 50, 0);

        // InitiativeTrack
        InitiativeTrack initiativeTrack = new InitiativeTrack();

        // Tworzymy obiekt Board dla dwóch graczy
        List<ActionField> actionFields = Arrays.asList(actionField1, actionField2);
        List<Land> lands = Arrays.asList(land1);
        List<HeroCard> heroCards = Arrays.asList(heroCard1, heroCard2);

        Board board = new Board(viperGorge, actionFields, lands, heroCards, initiativeTrack, 0, 10);

        when(boardFactory.boardFactory(anyList())).thenReturn(board);
        // When
        Game result = gameFactory.gameFactory(List.of(player1, player2));
        //Then
        Assertions.assertEquals(2, result.getPlayers().size());
        Assertions.assertEquals(6, result.getLandTokens().size());

    }
}
