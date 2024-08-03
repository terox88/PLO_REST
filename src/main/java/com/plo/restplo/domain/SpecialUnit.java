package com.plo.restplo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Getter
@NoArgsConstructor
public class SpecialUnit implements Unit{
    private String name;
    private Color color;
    private int level;
    List<AbilitiesType> getAbilities(){
        return new ArrayList<>();
    }

}
