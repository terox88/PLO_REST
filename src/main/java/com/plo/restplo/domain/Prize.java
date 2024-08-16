package com.plo.restplo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Prize {
    private final PrizeToken prizeType;
    private final int quantity;
    private boolean wasTaken;

    public void setWasTaken(boolean wasTaken) {
        this.wasTaken = wasTaken;
    }
}
