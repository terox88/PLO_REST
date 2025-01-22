package com.plo.restplo.service;

import com.plo.restplo.domain.Game;
import com.plo.restplo.domain.LandToken;
import com.plo.restplo.domain.dto.GameDto;
import com.plo.restplo.domain.dto.LandTokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameMapper {
    private final BoardMapper boardMapper;

    public GameDto mapToGameDto(Game game) {
        return new GameDto(game.getId(), boardMapper.mapToBoardDto(game.getBoard()), mapToLandTokenDtoList(game.getLandTokens()), boardMapper.mapToPlayerDto(game.getActivePlayer()), game.isEnded(), boardMapper.mapToPlayerDto(game.getWinner()), game.getCurrentPlayersOrder() == null ? new ArrayList<>() : game.getCurrentPlayersOrder());
    }

    public List<LandTokenDto> mapToLandTokenDtoList(List<LandToken> landTokens) {
        List<LandTokenDto> landTokenDtos = new ArrayList<>();
        for (LandToken landToken : landTokens) {
            landTokenDtos.add(boardMapper.mapToLandTokenDto(landToken));
        }
        return landTokenDtos;
    }
}
