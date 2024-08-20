package com.plo.restplo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Getter
public class InitiativeTrack {
    private final List<Stage> stages;
   private final Board board;

}
