package com.plo.restplo;

import com.plo.restplo.domain.Hero;
import com.plo.restplo.domain.Player;
import com.plo.restplo.validation.PlayersValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PlayersValidatorTest {
    @Autowired
    PlayersValidator playersValidator;
    @Test
    void nullListTest() {
        //Given
        List<Player> players = null;
        //When
        boolean result = playersValidator.isNotNull(players);
        //Then
        Assertions.assertFalse(result);
    }
    @Test
    void notNullListTest(){
        //Given
        List<Player> players = List.of(new Player("Player1", Hero.PASSIONARIA));
        //When
        boolean result = playersValidator.isNotNull(players);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void lessThanTwoTest() {
        //Given
        List<Player> players = List.of(new Player("Player1", Hero.PASSIONARIA));
        //When
        boolean result = playersValidator.isMoreThanOne(players);
        //Then
        Assertions.assertFalse(result);
    }

    @Test
    void moreThanOneTest() {
        //Given
        List<Player> players = List.of(new Player("Player1", Hero.PASSIONARIA), new Player("Player2", Hero.PASSIONARIA));
        //When
        boolean result = playersValidator.isMoreThanOne(players);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void duplicatedHeroTest() {
        //Given
        List<Player> players = List.of(new Player("Player1", Hero.PASSIONARIA), new Player("Player2", Hero.PASSIONARIA));
        //When
        boolean result = playersValidator.isHaveUniqeHeros(players);
        //Then
        Assertions.assertFalse(result);
    }

    @Test
    void uniqedHeroTest() {
        //Given
        List<Player> players = List.of(new Player("Player1", Hero.PASSIONARIA), new Player("Player2", Hero.OLAF));
        //When
        boolean result = playersValidator.isHaveUniqeHeros(players);
        //Then
        Assertions.assertTrue(result);
    }


}
