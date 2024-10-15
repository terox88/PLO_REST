package com.plo.restplo;

import com.plo.restplo.domain.*;
import com.plo.restplo.domain.dto.BoardDto;
import com.plo.restplo.service.BoardMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;
    private Board board;

    @BeforeEach
    void preparingData() {
        Player player1 = new Player("Player 1", Hero.PASSIONARIA);
        Player player2 =new Player("Player 2", Hero.OLAF);

        ViperGorge viperGorge = new ViperGorge();
        viperGorge.setBlackMarkers(3);
        viperGorge.setRedMarkers(2);
        viperGorge.setGreenMarkers(1);
        viperGorge.setBlueMarkers(4);

        ActionField actionField1 = new ActionField(ActionFieldType.INFLUENCES, 6);
        ActionField actionField2 = new ActionField(ActionFieldType.MOVE, 4);
        Prize prize = new Prize(1);

        Land land1 = new Land(1, new int[]{2, 3}, 2);
        land1.setLandToken(new LandToken(1, prize, prize, prize,3, 2, 1));
        Land land2 = new Land(2, new int[]{4, 5, 6}, 1);
        land2.setLandToken(new LandToken(1, prize, prize, prize,3, 2, 1));
        Abilities abilities1 = new Abilities(List.of(AbilitiesType.ATTACK, AbilitiesType.DRAKAR), List.of(AbilitiesType.SPEED, AbilitiesType.DRAKAR, AbilitiesType.FAUN), List.of(AbilitiesType.NIGHTMARE));
        Abilities abilities2 = new Abilities(List.of(AbilitiesType.ATTACK), List.of(AbilitiesType.SPEED, AbilitiesType.DRAKAR), List.of(AbilitiesType.NIGHTMARE));
        List<InfluenceMarker> influenceMarkersGreen = List.of(new InfluenceMarker(Color.GREEN), new InfluenceMarker(Color.GREEN));
        List<InfluenceMarker> influenceMarkersRed = List.of(new InfluenceMarker(Color.RED), new InfluenceMarker(Color.RED), new InfluenceMarker(Color.RED));
        List<ActionMarker> actionMarkersGreen = List.of(new ActionMarker(Color.GREEN), new ActionMarker(Color.GREEN), new ActionMarker(Color.GREEN));
        List<ActionMarker> actionMarkersRed = List.of(new ActionMarker(Color.RED), new ActionMarker(Color.RED), new ActionMarker(Color.RED));

        HeroCard heroCard1 = new HeroCard(player1, Hero.PASSIONARIA, abilities1, influenceMarkersGreen, actionMarkersGreen, 1, 2, 3, 100, 50, 1);
        HeroCard heroCard2 = new HeroCard(player2, Hero.OLAF, abilities2, influenceMarkersRed, actionMarkersRed, 1, 2, 3, 100, 50, 1);

        List<Stage> stages = List.of(new Stage(1,3));
        stages.get(0).getRounds().add(new Round(1, false, 3, stages.get(0)));
        InitiativeTrack initiativeTrack = new InitiativeTrack(stages);

        List<ActionField> actionFields = Arrays.asList(actionField1, actionField2);
        List<Land> lands = List.of(land1, land2);
        List<HeroCard> heroCards = Arrays.asList(heroCard1, heroCard2);
        board = new Board(viperGorge, actionFields,lands,heroCards,initiativeTrack,20,30);
        actionField1.setBoard(board);
        actionField2.setBoard(board);
        land1.setBoard(board);
        land2.setBoard(board);

    }

    @Test
    void accuracyTest(){
        //When
        BoardDto boardDto = boardMapper.mapToBoardDto(board);
        //Then
        Assertions.assertEquals(3, boardDto.getViperGorgeDto().getBlackMarkers());
        Assertions.assertEquals(2, boardDto.getViperGorgeDto().getRedMarkers());
        Assertions.assertEquals(1, boardDto.getInitiativeTrackDto().getStagesDto().get(0).getRounds().size());
        Assertions.assertEquals(Hero.PASSIONARIA, boardDto.getHeroCardsDto().get(0).getHero());
    }
}
