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

    public Game setPlayersOrder(Game game, List<Hero> order) {
        game.getBoard().getInitiativeTrack().getStages().get(0).getRounds().get(0).getMarkers().clear();
        for (int i = order.size(); i > 0; i--) {
            game.getBoard().getInitiativeTrack().getStages().get(0).getRounds().get(0).getMarkers().addFirst(new InitiativeMarker(order.get(i-1).getColor()));
        }
        return game;
    }
    public Game setRandomPlayersOrder(Game game) {
        List<Hero> heroes = new ArrayList<>(game.getBoard().getHeroCards().stream().map(HeroCard::getHero).toList());
        List<Hero> order =new ArrayList<>();

        while (!heroes.isEmpty()) {
            int index = random.nextInt(heroes.size());
            order.addFirst(heroes.get(index));
            heroes.remove(index);
        }

        return setPlayersOrder(game, order);
    }
}
