package com.plo.restplo.validation;

import com.plo.restplo.domain.Board;
import org.springframework.stereotype.Component;

@Component
public class GameValidator {

    public boolean isFirstInfluenceDone(Board board) {

        long influences = board.getLands().stream().flatMap(i -> i.getInfluenceMarkers().stream()).count();
        int influenceLimit = board.getHeroCards().size() * 2;
        if (influenceLimit == influences) {
            return true;
        }else {
            return false;
        }
    }

}
