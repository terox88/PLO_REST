package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Uroczysko {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    private boolean isReal;
    private boolean isFliped;
    @ManyToOne
    @JoinColumn(name = "LAND_ID")
    private Land land;
}
