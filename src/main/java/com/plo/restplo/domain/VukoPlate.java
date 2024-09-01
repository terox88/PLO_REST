package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@Entity
public class VukoPlate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    private VukoPlateType vukoPlateType;
    private boolean isAllGame;

    public VukoPlate(VukoPlateType vukoPlateType, boolean isAllGame) {
        this.vukoPlateType = vukoPlateType;
        this.isAllGame = isAllGame;
    }
}
