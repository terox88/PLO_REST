package com.plo.restplo.service;

import com.plo.restplo.domain.*;
import com.plo.restplo.exception.BoardNotFoundException;
import com.plo.restplo.exception.GameNotFoundException;
import com.plo.restplo.repository.BoardRepository;
import com.plo.restplo.repository.GameRepository;
import com.plo.restplo.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {
    private final BoardRepository boardRepository;
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;

    public Board saveBoard(Board board) {
        for (ActionField actionField : board.getActionFields()) {
            actionField.setBoard(board);

            for (ActionMarker actionMarker : actionField.getActionMarkers()) {
                actionMarker.setActionField(actionField);
            }
        }
        for (HeroCard heroCard : board.getHeroCards()) {
            heroCard.setBoard(board);
            for (InfluenceMarker influenceMarker: heroCard.getInfluenceMarkers()) {
                influenceMarker.setHeroCard(heroCard);
            }
            for (ActionMarker actionMarker : heroCard.getActionMarkers()) {
                actionMarker.setHeroCard(heroCard);
            }
        }
        for (InfluenceMarker influenceMarker : board.getIceGarden()) {
            influenceMarker.setBoard(board);
        }
        for (Land land : board.getLands()) {
            land.setBoard(board);
            for (InfluenceMarker influenceMarker : land.getInfluenceMarkers()) {
                influenceMarker.setLand(land);
            }
            for (Uroczysko uroczysko : land.getUroczyska()) {
                uroczysko.setLand(land);
            }
            for (SpecialUnit specialUnit : land.getSpecialUnits()) {
                specialUnit.setLand(land);
            }
        }
        for (Stage stage : board.getInitiativeTrack().getStages()) {
            stage.setInitiativeTrack(board.getInitiativeTrack());
            for (Round round : stage.getRounds()) {
                round.setStage(stage);
            }
        }
        return boardRepository.save(board);
    }
    public void deleteBoard(long id) {
       boardRepository.deleteById(id);
    }
    public List<Board> getAllBoards() {
        return new ArrayList<>(boardRepository.findAll());
    }
    public Board getBoard(long id) throws BoardNotFoundException {
        return boardRepository.findById(id).orElseThrow(BoardNotFoundException:: new);
    }
    public void deleteAllBoards(){
        boardRepository.deleteAll();
    }

    public Game saveGame(Game game) {

        for (LandToken landToken : game.getLandTokens()){
            landToken.setGame(game);
        }

        return gameRepository.save(game);
    }

    public Game getGame(long id) throws GameNotFoundException {
        return gameRepository.findById(id).orElseThrow(GameNotFoundException:: new);
    }
    public List<Game> getAllGames () {
        return new ArrayList<>(gameRepository.findAll());
    }

    public void deleteGame(long id) {
        gameRepository.deleteById(id);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(long id) {
        playerRepository.deleteById(id);
    }


}
