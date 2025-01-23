package com.plo.restplo.domain.dto;

import com.plo.restplo.domain.Board;
import com.plo.restplo.domain.Hero;
import com.plo.restplo.domain.LandToken;
import com.plo.restplo.domain.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class GameDto {
    private long id;

    private BoardDto boardDto;
    private List<LandTokenDto> landTokensDto;

    private PlayerDto activePlayer;

    private boolean isEnded;
    private boolean isPrepDone;

    private PlayerDto winner;
    private List<Hero> currentPlayersOrder;
}
