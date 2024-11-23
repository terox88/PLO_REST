package com.plo.restplo.factory;

import com.plo.restplo.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameFactory {
    private final BoardFactory boardFactory;

    public Game gameFactory(List<Player> players){
        return new Game(boardFactory.boardFactory(players), landTokenCreator(players.size()));
    }

    public List<LandToken> landTokenCreator(int numberOfPlayers) {
        List<LandToken> landTokens = new ArrayList<>();
        int limit = numberOfPlayers + 5;
        for (int i = 1; i < limit; i++) {
            landTokens.add(new LandToken(i, manaPrizeCreator(numberOfPlayers, i), goldPrizeCreator(numberOfPlayers, i), populationPrizeCreator(numberOfPlayers, i),
                    winnerPointsCreator(numberOfPlayers, i), secondPlacePointsCreator(numberOfPlayers, i), thirdPlacePointsCreator(numberOfPlayers, i)));
        }
        return landTokens;
    }

    public Prize manaPrizeCreator(int numberOfPlayers, int order) {
       if (numberOfPlayers == 2) {
           return switch (order) {
               case 1, 2, 5, 6 -> new Prize(0);
               case 3, 4 -> new Prize(1);
               default -> new Prize(-1);
           };
       } else if (numberOfPlayers == 3) {
           return switch (order) {
               case 1, 4, 6, 7 -> new Prize(0);
               case 2, 3, 5 -> new Prize(1);
               default -> new Prize(-1);

            };
        }else {
           return switch (order) {
               case 1, 5, 7, 8 -> new Prize(0);
               case 2, 3, 4,6 -> new Prize(1);
               default -> new Prize(-1);

            };
       }
       }
    public Prize goldPrizeCreator(int numberOfPlayers, int order) {
        if (numberOfPlayers == 2) {
            return switch (order) {
                case 1, 2, 3, 4, 6 -> new Prize(1);
                case 5 -> new Prize(2);
                default -> new Prize(-1);
            };
        } else if (numberOfPlayers == 3) {
            return switch (order) {
                case 1, 2, 3, 4 -> new Prize(1);
                case 5, 6, 7 -> new Prize(2);
                default -> new Prize(-1);

            };
        }else {
            return switch (order) {
                case 1, 2, 3, 4, 5 -> new Prize(1);
                case 6, 7, 8 -> new Prize(2);
                default -> new Prize(-1);

            };
        }
    }

    public Prize populationPrizeCreator(int numberOfPlayers, int order) {
        if (numberOfPlayers == 2) {
            return switch (order) {
                case 1, 2, 3, 4, 5 -> new Prize(1);
                case 6 -> new Prize(2);
                default -> new Prize(-1);
            };
        } else if (numberOfPlayers == 3) {
            return switch (order) {
                case 1, 2, 3, 5 -> new Prize(1);
                case 4, 6, 7 -> new Prize(2);
                default -> new Prize(-1);

            };
        }else {
            return switch (order) {
                case 1, 2, 3, 4, 6 -> new Prize(1);
                case 5, 7, 8 -> new Prize(2);
                default -> new Prize(-1);

            };
        }
    }

    public int winnerPointsCreator(int numberOfPlayers, int order) {
        if (numberOfPlayers == 2) {
            return switch (order) {
                case 1, 2, 3 -> 5;
                case 4, 5 -> 4;
                case 6 -> 3;
                default -> -1;
            };
        } else if (numberOfPlayers == 3) {
            return switch (order) {
                case 1 -> 6;
                case 2, 3, 4 -> 5;
                case 5, 6, 7 -> 4;
                default -> -1;

            };
        }else {
            return switch (order) {
                case 1, 2, 3 -> 6;
                case 4, 5, 6 -> 5;
                case 7,8 -> 4;
                default -> -1;

            };
        }

    }
    public int secondPlacePointsCreator(int numberOfPlayers, int order) {
        if (numberOfPlayers == 2) {
            return switch (order) {
                case 1 -> 4;
                case 2, 3 -> 3;
                case 4, 5, 6 -> 2;
                default -> -1;
            };
        } else if (numberOfPlayers == 3) {
            return switch (order) {
                case 1 -> 4;
                case 2, 3, 4 -> 3;
                case 5, 6, 7 -> 2;
                default -> -1;

            };
        }else {
            return switch (order) {
                case 1, 2, 3 -> 4;
                case 4, 5, 6 -> 3;
                case 7,8 -> 2;
                default -> -1;

            };
        }

    }

    public int thirdPlacePointsCreator(int numberOfPlayers, int order) {
        if (numberOfPlayers == 2) {
            return -1;
        } else if (numberOfPlayers == 3) {
            return switch (order) {
                case 1 -> 3;
                case 2, 3, 4 -> 2;
                case 5, 6, 7 -> 1;
                default -> -1;

            };
        }else {
            return switch (order) {
                case 1, 2, 3 -> 3;
                case 4, 5, 6 -> 2;
                case 7,8 -> 1;
                default -> -1;

            };
        }

    }
}
