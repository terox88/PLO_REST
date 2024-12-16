package com.plo.restplo.service;

import com.plo.restplo.domain.*;
import com.plo.restplo.exception.NotEnoughPlayerException;
import com.plo.restplo.exception.NotUniqueHerosException;
import com.plo.restplo.exception.NullElementException;
import com.plo.restplo.factory.GameFactory;
import com.plo.restplo.validation.PlayersValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GameService {
    private final DbService dbService;
    private final GameFactory gameFactory;
    private final PlayersValidator playersValidator;
    private final Random random;

    public Game gameCreator(List<Player> players) throws NullElementException, NotEnoughPlayerException, NotUniqueHerosException{
        if(playersValidator.isNotNull(players) && playersValidator.isHaveUniqeHeros(players)
                && playersValidator.isMoreThanOne(players)) {
            return gameFactory.gameFactory(players);
        }else {
            if (!playersValidator.isNotNull(players)) {
                throw new NullElementException();
            } else if (!playersValidator.isMoreThanOne(players)) {
                throw new NotEnoughPlayerException();
            } else if (!playersValidator.isHaveUniqeHeros(players)) {
                throw new NotUniqueHerosException();
            } else {
                return new Game();
            }
        }
    }

    public Game playersOrderSetting(Game game, List<Hero> order) {
        game.getBoard().getInitiativeTrack().getStages().get(0).getRounds().get(0).getMarkers().clear();
        for (int i = 0; i < order.size(); i++) {
            InitiativeMarker marker = new InitiativeMarker(order.get(i).getColor());
            marker.setRound(game.getBoard().getInitiativeTrack().getStages().get(0).getRounds().get(0));
            game.getBoard().getInitiativeTrack().getStages().get(0).getRounds().get(0).getMarkers().addFirst(marker);
        }
        return game;
    }
    public Game randomPlayersOrderSetting(Game game) {
        List<Hero> heroes = new ArrayList<>(game.getBoard().getHeroCards().stream().map(HeroCard::getHero).toList());
        List<Hero> order =new ArrayList<>();

        while (!heroes.isEmpty()) {
            int index = random.nextInt(heroes.size());
            order.addFirst(heroes.get(index));
            heroes.remove(index);
        }

        return playersOrderSetting(game, order);
    }
    public Hero colorToHeroConversion (Color color) {
        return switch (color){
            case RED -> Hero.ULRIKE;
            case BLUE -> Hero.OLAF;
            case BLACK -> Hero.PIER;
            case GREEN -> Hero.PASSIONARIA;
        };
    }

    public List<Hero> getInitiativeOrder(InitiativeTrack initiativeTrack) {
        List<Hero> order = new ArrayList<>();
        for (int s = initiativeTrack.getStages().size(); s > 0; s--) {
            Stage stage = initiativeTrack.getStages().get(s);
            for (Round round : stage.getRounds()) {
                if(!round.getMarkers().isEmpty()) {
                    List<InitiativeMarker> markers = round.getMarkers();
                    while(!markers.isEmpty()) {
                        order.add(colorToHeroConversion(markers.getLast().getColor()));
                        markers.removeLast();
                    }
                }
            }

        }
        return order;
    }

    public Player heroToPlayerConversion(List<HeroCard> cards, Hero hero) {
        for (HeroCard heroCard : cards) {
            if (heroCard.getHero() == hero) {
                return heroCard.getPlayer();
            }
        }
        return new Player();
    }

}
