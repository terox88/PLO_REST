package com.plo.restplo.service;

import com.plo.restplo.domain.*;
import com.plo.restplo.exception.*;
import com.plo.restplo.factory.GameFactory;
import com.plo.restplo.validation.GameValidator;
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
    private final GameValidator gameValidator;

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
            Stage stage = initiativeTrack.getStages().get(s-1);
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
    public Player getActivePlayer(Game game) {
        return game.getActivePlayer();
    }
    public Game setActivePlayerByInitiative(Game game) {
        if(game.getCurrentPlayersOrder().isEmpty()) {
          game.setCurrentPlayersOrder(getInitiativeOrder(game.getBoard().getInitiativeTrack()));
        }
        game.setActivePlayer(heroToPlayerConversion(game.getBoard().getHeroCards(), game.getCurrentPlayersOrder().getFirst()));
        game.getCurrentPlayersOrder().removeFirst();

        return game;
    }
    public Game setActivePlayerByActionField(Game game, List<ActionMarker> actionMarkers) throws EmptyFieldException{
        if (actionMarkers.isEmpty()){
            throw new EmptyFieldException();
        }else {
            game.setActivePlayer(heroToPlayerConversion(game.getBoard().getHeroCards(), colorToHeroConversion(actionMarkers.getLast().getColor())));
        }
        return game;
    }



    public Game putLandToken(Game game, int landNumber) throws NoSuchLandException, PuttingDoneException {
        if(landNumber > 8 || landNumber < 1) {
            throw new NoSuchLandException();
        } else if (game.getLandTokens().isEmpty()) {
            throw new PuttingDoneException();

        } else {
            int index = random.nextInt(game.getLandTokens().size());
            LandToken landToken = game.getLandTokens().get(index);
            if(game.getBoard().getLands().get(landNumber-1).getLandToken() == null) {
                game.getBoard().getLands().get(landNumber -1).setLandToken(landToken);
                game.getLandTokens().remove(index);
                game.getBoard().getLands().get(landNumber -1).setInGame(true);
            }
        }
        return game;

    }

    public Board firstPutInfluence(Board board, int landNumber, InfluenceMarker influenceMarker) throws OneLandOneColorException {
        Land land = board.getLands().get(landNumber -1);
        if (gameValidator.firstInfluenceOnlyOneCheck(land, influenceMarker)){
            influenceMarker.setHeroCard(null);
            land.getInfluenceMarkers().add(influenceMarker);
            influenceMarker.setLand(land);

            return board;
        }else {
            throw new OneLandOneColorException();
        }

    }

    public Board putThorne(Board board, int landNumber) throws NoSuchLandException {
        Land land = board.getLands().get(landNumber -1);
        if(land.isInGame()) {
            land.setHasThorn(true);
            return board;
        }else {
            throw new NoSuchLandException();
        }
    }

    public Board placeUroczyska(Board board) {

        List<Land> landsInGame = new ArrayList<>();

        for (Land land : board.getLands()) {
            if (land.isInGame()) {
                landsInGame.add(land);
            }
        }
        List<Uroczysko> uroczyska = List.of(new Uroczysko(), new Uroczysko(), new Uroczysko(), new Uroczysko());

        while (!uroczyska.isEmpty()) {
            int index = random.nextInt(landsInGame.size());
            if(!landsInGame.get(index).isHasThorn()){
                Uroczysko uroczysko = uroczyska.getFirst();
                uroczysko.setLand(landsInGame.get(index));
                landsInGame.get(index).getUroczyska().add(uroczysko);
                uroczyska.removeFirst();
                landsInGame.remove(index);
            }
        }
        return board;
    }



}
