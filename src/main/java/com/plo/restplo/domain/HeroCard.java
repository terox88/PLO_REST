package com.plo.restplo.domain;

import java.util.Queue;

public interface HeroCard {
    User getUser();
    Abilities getAbilities();
    String getHero();
    Queue<InfluenceMarker> getInfluenceMarker();
    Queue<ActionMarker> getActionMarker();
    Queue<Token> getGold();
    Queue<Token> getPopulation();
    Queue<Token> getManaFromZero();
    Queue<Token> getManaFromOne();
    Queue<Token> getManaFromTwo();
    Queue<Token> getManaFromThree();
    Queue<Token> getVukoToken();


}
