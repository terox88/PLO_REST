package com.plo.restplo.factory;

import com.plo.restplo.domain.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public final class BoardFactory {
    private ViperGorge viperGorgeCreator() {
        return new ViperGorge();
    }
    private List<ActionField> actionFieldsCreator(final int players) {
        List<ActionField> actionFields = new ArrayList<>();
        actionFields.add(new ActionField(ActionFieldType.INFLUENCES, 8));
        actionFields.add(new ActionField(ActionFieldType.MOVE, players == 2 ? 3 : 4));
        actionFields.add(new ActionField(ActionFieldType.MOUNTAIN, players == 2 ? 3 : 4));
        actionFields.add(new ActionField(ActionFieldType.SHADOW_RAVE, players == 2 ? 3 : 4));
        actionFields.add(new ActionField(ActionFieldType.MAKING, players == 2 ? 3 : 4));
        return actionFields;

    }
    private int [] neighboursCreator(int number) {
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

    private List<Land> landsCreator() {
        List<Land> lands = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            lands.add(new Land(i,neighboursCreator(i), 1));
        }
        return lands;
    }
    private List<HeroCard> heroCardsCreator (List<Player> players) {
        List<HeroCard> heroCards = new ArrayList<>();
        for (Player player : players) {

            heroCards.add(new HeroCard())

        }
    }
    private Queue<InfluenceMarker> influenceMarkersCreator(Hero hero, HeroCard heroCard) {
        Queue<InfluenceMarker> influenceMarkers = new ArrayDeque<>();
        Color color = switch (hero) {
            case OLAF -> Color.BLUE;
            case ULRIKE -> Color.RED;
            case PIER -> Color.BLACK;
            case PASSIONARIA -> Color.GREEN;
        };
        for (int i = 0; i < InfluenceMarker.limit; i++) {
            influenceMarkers.add(new InfluenceMarker(color, heroCard));
        }
        return influenceMarkers;
    }

    private Abilities abilitiesCreator(Hero hero) {
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

}
