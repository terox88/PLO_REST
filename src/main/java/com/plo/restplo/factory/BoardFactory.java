package com.plo.restplo.factory;

import com.plo.restplo.domain.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public final class BoardFactory {
    public Board boardFactory(List<Player> players) {

        if (players.size() < 3) {
            return new Board(new ViperGorge(),actionFieldsCreator(players.size()),landsCreator(),heroCardsCreator(players),new InitiativeTrack(stagesCreator()),0,18);
        } else if (players.size() == 3) {
            return new Board(new ViperGorge(),actionFieldsCreator(players.size()),landsCreator(),heroCardsCreator(players),new InitiativeTrack(stagesCreator()),0,24);
        } else {
            return new Board(new ViperGorge(),actionFieldsCreator(players.size()),landsCreator(),heroCardsCreator(players),new InitiativeTrack(stagesCreator()),0,30);
        }

    }

    public List<ActionField> actionFieldsCreator(final int players) {
        List<ActionField> actionFields = new ArrayList<>();
        actionFields.add(new ActionField(ActionFieldType.INFLUENCES, 8));
        actionFields.add(new ActionField(ActionFieldType.MOVE, players == 2 ? 3 : 4));
        actionFields.add(new ActionField(ActionFieldType.MOUNTAIN, players == 2 ? 3 : 4));
        actionFields.add(new ActionField(ActionFieldType.SHADOW_RAVE, players == 2 ? 3 : 4));
        actionFields.add(new ActionField(ActionFieldType.MAKING, players == 2 ? 3 : 4));
        return actionFields;

    }
    public int [] neighboursCreator(int number) {
       return switch (number) {
            case 1 -> new int [] {2, 4, 5};
            case 2 -> new int[] {1, 3, 5, 6};
            case 3 -> new int[] {2, 6, 7};
            case 4 -> new int[] {1, 5, 8};
            case 5 -> new int[] {1, 2, 4, 6, 8};
            case 6 -> new int[] {2, 3, 5, 7, 8};
            case 7 -> new int[] {3, 6, 8};
            case 8 -> new int[] {4, 5, 6, 7};
           default -> new int[]{0};
        };
    }

    public List<Land> landsCreator() {
        List<Land> lands = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            lands.add(new Land(i,neighboursCreator(i), 1));
        }
        return lands;
    }
    public List<HeroCard> heroCardsCreator (List<Player> players) {
        List<HeroCard> heroCards = new ArrayList<>();
        for (Player player : players) {

            heroCards.add(new HeroCard(player,player.getHero(),abilitiesCreator(player.getHero()), influenceMarkersCreator(player.getHero()),actionMarkersCreator(player.getHero()),3,2,1,2,4,1));

        }
        return heroCards;
    }
    public Queue<InfluenceMarker> influenceMarkersCreator(Hero hero) {
        Queue<InfluenceMarker> influenceMarkers = new ArrayDeque<>();
        Color color = switch (hero) {
            case OLAF -> Color.BLUE;
            case ULRIKE -> Color.RED;
            case PIER -> Color.BLACK;
            case PASSIONARIA -> Color.GREEN;
        };
        for (int i = 0; i < InfluenceMarker.limit; i++) {
            influenceMarkers.add(new InfluenceMarker(color));
        }
        return influenceMarkers;
    }

    public Queue<ActionMarker> actionMarkersCreator(Hero hero) {
        Queue<ActionMarker> actionMarkers = new ArrayDeque<>();
        Color color = switch (hero) {
            case OLAF -> Color.BLUE;
            case ULRIKE -> Color.RED;
            case PIER -> Color.BLACK;
            case PASSIONARIA -> Color.GREEN;
        };
        for (int i = 0; i < ActionMarker.limit; i++) {
            actionMarkers.add(new ActionMarker(color));
        }
        return actionMarkers;
    }

    public Abilities abilitiesCreator(Hero hero) {
        List<AbilitiesType> levOne = switch (hero) {
            case OLAF, PASSIONARIA, ULRIKE -> new ArrayList<>(List.of(AbilitiesType.ATTACK));
            case PIER -> new ArrayList<>(List.of(AbilitiesType.ATTACK, AbilitiesType.ATTACK));
        };
        List<AbilitiesType> levTwo = switch (hero){
            case OLAF -> new ArrayList<>(List.of(AbilitiesType.DRAKAR, AbilitiesType.ICE_GARDEN));
            case PASSIONARIA -> new ArrayList<>(List.of(AbilitiesType.FAUN));
            case ULRIKE -> new ArrayList<>(List.of(AbilitiesType.PILLAGE));
            case PIER -> new ArrayList<>(List.of(AbilitiesType.PIPER));
        };
        List<AbilitiesType> levThree = switch (hero){
            case OLAF -> new ArrayList<>(List.of(AbilitiesType.ATTACK, AbilitiesType.SHIELD));
            case PASSIONARIA -> new ArrayList<>(List.of(AbilitiesType.NIGHTMARE,AbilitiesType.SHIELD));
            case ULRIKE -> new ArrayList<>(List.of(AbilitiesType.MAKER_SPY, AbilitiesType.MAKER_SPY));
            case PIER -> new ArrayList<>(List.of(AbilitiesType.ATTACK, AbilitiesType.SPEED));
        };
        return new Abilities(levOne, levTwo, levThree);

    }

    public Round roundsCreator (int stageNumber, int order, Stage stage) {
        switch (order) {
            case 1: {
                if (stageNumber == 1){
                    return new Round(order,false,3,stage);
                }else if (stageNumber == 2) {
                    return new Round(order,true,3,stage);
                } else  {
                    return new Round(order,true,4,stage);
                }
            }
            case 2: {
                if (stageNumber < 3) {
                    return new Round(order,false,4,stage);
                } else if (stageNumber == 3) {
                    return new Round(order,false,5,stage);
                } else if (stageNumber == 4) {
                    return new Round(order,true,5,stage);
                }

            }
            case 3:
                return new Round(order,false,5,stage);

            default: return null;
        }
    }

    public List<Stage> stagesCreator () {
        List<Stage> stages = new ArrayList<>();
        stages.add(new Stage(1,3));
        stages.add(new Stage(2,3));
        stages.add(new Stage(3,2));
        stages.add(new Stage(4,2));

        for (Stage stage : stages) {
            for (int i = 1; i < stage.getNumberOfRounds()+1; i++) {
                stage.getRounds().add(roundsCreator(stage.getStageNumber(), i, stage));
            }
        }
        return stages;
    }
}
