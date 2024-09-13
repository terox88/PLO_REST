package com.plo.restplo;

import com.plo.restplo.domain.*;
import com.plo.restplo.factory.BoardFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class BoardFactoryTest {
    @Test
    public void boardFactoryTwoPlayersTest () {
        //Given
        List<Player> players = List.of(new Player("Jacek", Hero.OLAF), new Player("Ada",Hero.PASSIONARIA));
        BoardFactory boardFactory = new BoardFactory();
        //When
        Board board = boardFactory.boardFactory(players);
        //Then
        assertEquals(2, board.getHeroCards().size());
        assertEquals(18, board.getDeadSnowLimit());
    }
    @Test
    public void testBoardFactoryThreePlayers() {
        // Given
        List<Player> players = List.of(new Player("Player1", Hero.OLAF), new Player("Player2", Hero.ULRIKE), new Player("Player3", Hero.PIER));
        BoardFactory boardFactory = new BoardFactory();

        // When
        Board board = boardFactory.boardFactory(players);

        // Then
        assertNotNull(board);
        assertEquals(24, board.getDeadSnowLimit());
        assertEquals(3, board.getHeroCards().size());
    }

    @Test
    public void testBoardFactoryFourPlayers() {
        // Arrange
        List<Player> players = List.of(new Player("Player1", Hero.OLAF), new Player("Player2", Hero.ULRIKE), new Player("Player3", Hero.PIER), new Player("Player4", Hero.PASSIONARIA));
        BoardFactory boardFactory = new BoardFactory();

        // Act
        Board board = boardFactory.boardFactory(players);

        // Assert
        assertNotNull(board);
        assertEquals(30, board.getDeadSnowLimit());
        assertEquals(4, board.getHeroCards().size());
    }

    @Test
    public void testHeroAbilitiesCreator() {
        // Arrange
        BoardFactory boardFactory = new BoardFactory();

        // Test for Olaf
        Abilities olafAbilities = boardFactory.abilitiesCreator(Hero.OLAF);
        assertEquals(List.of(AbilitiesType.ATTACK), olafAbilities.getLevOneAbilitiesTypes());
        assertEquals(List.of(AbilitiesType.DRAKAR, AbilitiesType.ICE_GARDEN), olafAbilities.getLevTwoAbilitiesTypes());
        assertEquals(List.of(AbilitiesType.ATTACK, AbilitiesType.SHIELD), olafAbilities.getLevThreeAbilitiesTypes());

        // Test for Passionaria
        Abilities passionariaAbilities = boardFactory.abilitiesCreator(Hero.PASSIONARIA);
        assertEquals(List.of(AbilitiesType.ATTACK), passionariaAbilities.getLevOneAbilitiesTypes());
        assertEquals(List.of(AbilitiesType.FAUN), passionariaAbilities.getLevTwoAbilitiesTypes());
        assertEquals(List.of(AbilitiesType.NIGHTMARE, AbilitiesType.SHIELD), passionariaAbilities.getLevThreeAbilitiesTypes());

        // Test for Ulrike
        Abilities ulrikeAbilities = boardFactory.abilitiesCreator(Hero.ULRIKE);
        assertEquals(List.of(AbilitiesType.ATTACK), ulrikeAbilities.getLevOneAbilitiesTypes());
        assertEquals(List.of(AbilitiesType.PILLAGE), ulrikeAbilities.getLevTwoAbilitiesTypes());
        assertEquals(List.of(AbilitiesType.MAKER_SPY, AbilitiesType.MAKER_SPY), ulrikeAbilities.getLevThreeAbilitiesTypes());

        // Test for Pier
        Abilities pierAbilities = boardFactory.abilitiesCreator(Hero.PIER);
        assertEquals(List.of(AbilitiesType.ATTACK, AbilitiesType.ATTACK), pierAbilities.getLevOneAbilitiesTypes());
        assertEquals(List.of(AbilitiesType.PIPER), pierAbilities.getLevTwoAbilitiesTypes());
        assertEquals(List.of(AbilitiesType.ATTACK, AbilitiesType.SPEED), pierAbilities.getLevThreeAbilitiesTypes());
    }

    @Test
    public void testHeroCardsCreator() {
        // Given
        List<Player> players = List.of(new Player("Player1", Hero.OLAF), new Player("Player2", Hero.ULRIKE));
        BoardFactory boardFactory = new BoardFactory();

        // When
        List<HeroCard> heroCards = boardFactory.heroCardsCreator(players);

        // Then
        assertEquals(2, heroCards.size());
        assertEquals(Hero.OLAF, heroCards.get(0).getHero());
        Assertions.assertTrue(heroCards.get(0).getUnitsAbilities().getLevTwoAbilitiesTypes().contains(AbilitiesType.DRAKAR));
        assertEquals("Player1", heroCards.get(0).getPlayer().getName());
    }

    @Test
    public void testLandsCreator() {
        BoardFactory boardFactory = new BoardFactory();
        List<Land> lands = boardFactory.landsCreator();

        assertEquals(8, lands.size());
        Assertions.assertArrayEquals(new int[] {2, 4, 5}, lands.get(0).getNeighbors());
    }
}
