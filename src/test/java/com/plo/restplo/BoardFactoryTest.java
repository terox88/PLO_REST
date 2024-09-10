package com.plo.restplo;

import com.plo.restplo.domain.Board;
import com.plo.restplo.domain.Hero;
import com.plo.restplo.domain.Player;
import com.plo.restplo.factory.BoardFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class BoardFactoryTest {
    @Test
    public void boardFactoryTwoPlayersTest () {
        //Given
        List<Player> players = List.of(new Player("Jacek", Hero.OLAF), new Player("Ada",Hero.PASSIONARIA));
        BoardFactory boardFactory = new BoardFactory();
        //When
        Board board = boardFactory.boardFactory(players);
        //Then
        Assertions.assertEquals(2, board.getHeroCards().size());
        Assertions.assertEquals(18, board.getDeadSnowLimit());
    }
    @Test
    public void testBoardFactoryThreePlayers() {
        // Arrange
        List<Player> players = List.of(new Player("Player1", Hero.OLAF), new Player("Player2", Hero.ULRIKE), new Player("Player3", Hero.PIER));
        BoardFactory boardFactory = new BoardFactory();

        // Act
        Board board = boardFactory.boardFactory(players);

        // Assert
        assertNotNull(board);
        Assertions.assertEquals(24, board.getDeadSnowLimit());
        Assertions.assertEquals(3, board.getHeroCards().size());
    }
}
