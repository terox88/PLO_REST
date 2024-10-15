package com.plo.restplo.service;

import com.plo.restplo.domain.*;
import com.plo.restplo.domain.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardMapper {
    public BoardDto mapToBoardDto(Board board) {
        return new BoardDto(board.getId(),mapToViperGorgeDto(board.getViperGorge()),mapToActionFieldDtoList(board.getActionFields()),
                mapToLandDtoList(board.getLands()), mapToHeroCardDtoList(board.getHeroCards()), mapToInitiativeTrackDto(board.getInitiativeTrack()),
                board.getDeadSnowTrack(), board.getDeadSnowLimit(), mapToInfluenceMarekerDtoList(board.getIceGarden()));
    }
    public ViperGorgeDto mapToViperGorgeDto(ViperGorge viperGorge) {
        return new ViperGorgeDto(viperGorge.getId(), mapToActionMarkerDtoList(viperGorge.getActionMarkers()), viperGorge.getBlackMarkers(), viperGorge.getRedMarkers(), viperGorge.getGreenMarkers(), viperGorge.getBlueMarkers());
    }
    public List<ActionMarkerDto> mapToActionMarkerDtoList(List<ActionMarker> actionMarkers) {
        List<ActionMarkerDto> actionMarkerDtos = new ArrayList<>();
        for (ActionMarker actionMarker : actionMarkers) {
            actionMarkerDtos.add(new ActionMarkerDto(actionMarker.getId(),actionMarker.getColor()));
        }
        return actionMarkerDtos;
    }
    public ActionFieldDto mapToActionFieldDto(ActionField actionField) {
        return new ActionFieldDto(actionField.getId(), actionField.getActionFieldType(), mapToActionMarkerDtoList(actionField.getActionMarkers()), actionField.getMaxTrackSize(),actionField.getBoard().getId());
    }
    public List<ActionFieldDto> mapToActionFieldDtoList(List<ActionField> actionFields) {
        List<ActionFieldDto> actionFieldDtos = new ArrayList<>();
        for(ActionField actionField : actionFields) {
            actionFieldDtos.add(mapToActionFieldDto(actionField));
        }
        return actionFieldDtos;
    }

    public LandDto mapToLandDto(Land land) {
        return new LandDto(land.getId(), land.getNumber(), land.getNeighbors(), mapToLandTokenDto(land.getLandToken()),
                mapToUroszyskoDtoList(land.getUroczyska()), land.getNeutralMarkerQount(), mapToInfluenceMarekerDtoList(land.getInfluenceMarkers()),
               mapToSpecialUnitDtoList(land.getSpecialUnits()), land.isHasThorn(), land.getNightmareQount(), land.isHasTower(), land.isClosed(), land.isInGame(), land.isHasVuko(), land.getBoard().getId());
    }

    public List<LandDto> mapToLandDtoList(List<Land> lands) {
        List<LandDto> landDtos = new ArrayList<>();
        for (Land land : lands) {
            landDtos.add(mapToLandDto(land));
        }
        return landDtos;
    }

    public List<InfluenceMarkerDto> mapToInfluenceMarekerDtoList(List<InfluenceMarker> influenceMarkers) {
        List<InfluenceMarkerDto> influenceMarkerDtos = new ArrayList<>();
        for (InfluenceMarker influenceMarker : influenceMarkers) {
            influenceMarkerDtos.add(new InfluenceMarkerDto(influenceMarker.getId(), influenceMarker.getColor(),influenceMarker.getBoard() == null ? -1 : influenceMarker.getBoard().getId()));
        }
        return influenceMarkerDtos;
    }

    public LandTokenDto mapToLandTokenDto(LandToken landToken) {
        return new LandTokenDto(landToken.getId(), landToken.getOrderNumber(),mapToPrizeDto(landToken.getManaPrize()),
                mapToPrizeDto(landToken.getGoldPrize()), mapToPrizeDto(landToken.getPopulationPrize()),landToken.getGame() == null ? -1 : landToken.getGame().getId(),
                landToken.getWinnerPoints(), landToken.getSecondPlacePoints(), landToken.getThirdPlacePoints());
    }
     public PrizeDto mapToPrizeDto(Prize prize) {
        return new PrizeDto(prize.getId(), prize.getQuantity(), prize.isWasTaken());
     }

     public List<UroczyskoDto> mapToUroszyskoDtoList(List<Uroczysko> uroczyskos) {
        List<UroczyskoDto> uroczyskoDtos = new ArrayList<>();
        for (Uroczysko uroczysko : uroczyskos) {
            uroczyskoDtos.add(new UroczyskoDto(uroczysko.getId(), uroczysko.isReal(), uroczysko.isFliped(),uroczysko.getLand().getNumber()));
        }
        return uroczyskoDtos;
     }
     public List<SpecialUnitDto> mapToSpecialUnitDtoList(List<SpecialUnit> specialUnits) {
        List<SpecialUnitDto> specialUnitDtos = new ArrayList<>();
        for(SpecialUnit specialUnit :specialUnits) {
            specialUnitDtos.add(new SpecialUnitDto(specialUnit.getId(), specialUnit.getName(), specialUnit.getColor(),specialUnit.getLevel(), specialUnit.isKilled(), specialUnit.getLand().getNumber()));
        }
        return specialUnitDtos;
    }
    public AbilitiesDto mapToAbilitiesDto (Abilities abilities) {
        return new AbilitiesDto(abilities.getId(), abilities.getLevOneAbilitiesTypes(), abilities.getLevTwoAbilitiesTypes(), abilities.getLevThreeAbilitiesTypes());
    }
    public PlayerDto mapToPlayerDto(Player player) {
        return new PlayerDto(player.getId(), player.getName(), player.getHero(), player.getWinningPoints(), player.getReputation(), player.isHasWorstRep(), player.isHasFinishedGoal());
    }
    public HeroCardDto mapToHeroCardDto( HeroCard heroCard) {
        return new HeroCardDto(heroCard.getId(), mapToPlayerDto(heroCard.getPlayer()), heroCard.getHero(), mapToAbilitiesDto(heroCard.getUnitsAbilities()), mapToInfluenceMarekerDtoList(heroCard.getInfluenceMarkers()),
                mapToActionMarkerDtoList(heroCard.getActionMarkers()), heroCard.getBoard() == null ? -1 : heroCard.getBoard().getId(), heroCard.getUnitLevelOne(), heroCard.getUnitLevelTwo(), heroCard.getUnitLevelThree(),
                heroCard.getGold(), heroCard.getPopulation(), heroCard.getManaLevelZero(), heroCard.getManaLevelOne(), heroCard.getManaLevelTwo(), heroCard.getManaLevelThree(), heroCard.getVukoTokens());
    }

    public List<HeroCardDto> mapToHeroCardDtoList(List<HeroCard> heroCards) {
        List<HeroCardDto> heroCardDtos = new ArrayList<>();
        for (HeroCard heroCard : heroCards) {
            heroCardDtos.add(mapToHeroCardDto(heroCard));
        }
        return heroCardDtos;
    }
    public InitiativeMarkerDto mapToInitiativeMarkerDto(InitiativeMarker initiativeMarker) {
        return new InitiativeMarkerDto(initiativeMarker.getId(), initiativeMarker.getColor(), initiativeMarker.isTwoMovesFlag(), initiativeMarker.getRound().getStage().getStageNumber(), initiativeMarker.getRound().getOrderNumber());
    }
    public List<InitiativeMarkerDto> mapToInitiativeMarkerDtoList(List<InitiativeMarker> initiativeMarkers) {
        List<InitiativeMarkerDto> initiativeMarkerDtos = new ArrayList<>();
        for (InitiativeMarker initiativeMarker : initiativeMarkers) {
            initiativeMarkerDtos.addLast(mapToInitiativeMarkerDto(initiativeMarker));
        }
        return initiativeMarkerDtos;
    }
     public RoundDto mapToRoundDto(Round round) {
        return new RoundDto(round.getId(), round.getOrderNumber(), mapToInitiativeMarkerDtoList(round.getMarkers()), round.isScoring(),
                round.getActionMarkersQuantity(), round.getStage().getStageNumber());
     }

     public List<RoundDto> mapToRoundDtoList(List<Round> rounds) {
        List<RoundDto> roundDtos = new ArrayList<>();
        for (Round round : rounds) {
            roundDtos.add(mapToRoundDto(round));
        }
        return roundDtos;
     }
     public VukoPlateDto mapToVukoPlateDto(VukoPlate vukoPlate) {
        return vukoPlate == null ? null : new VukoPlateDto(vukoPlate.getId(), vukoPlate.getVukoPlateType(), vukoPlate.isAllGame());

     }

     public StageDto mapToStageDto(Stage stage) {
        return new StageDto(stage.getId(), stage.getNumberOfRounds(), stage.getStageNumber(), mapToRoundDtoList(stage.getRounds()),
                mapToVukoPlateDto(stage.getVukoPlate()));
     }

     public List<StageDto> mapToStageDtoList(List<Stage> stages) {
        List<StageDto> stageDtos = new ArrayList<>();
        for (Stage stage : stages){
            stageDtos.add(mapToStageDto(stage));
        }
        return stageDtos;
     }

     public InitiativeTrackDto mapToInitiativeTrackDto(InitiativeTrack initiativeTrack){
        return new InitiativeTrackDto(initiativeTrack.getId(), mapToStageDtoList(initiativeTrack.getStages()));
     }
}
