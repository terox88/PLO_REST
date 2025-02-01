package com.plo.restplo.validation;

import com.plo.restplo.domain.Board;
import com.plo.restplo.domain.InfluenceMarker;
import com.plo.restplo.domain.Land;
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

    public boolean firstInfluenceOnlyOneCheck(Land land, InfluenceMarker influenceMarker){
        for (InfluenceMarker influenceMarkerLoop : land.getInfluenceMarkers()) {
            if (influenceMarker.getColor() == influenceMarkerLoop.getColor()) {
                return false;

            }
        }
        return true;
    }

}
