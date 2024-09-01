package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@NoArgsConstructor
@Entity
@DynamicUpdate
public class SpecialUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    private  String name;
    private  Color color;
    private int level;
    @Setter
    private boolean isKilled;
    @Setter
    @ManyToOne
    @JoinColumn(name = "LAND_ID")
    private Land land;


}
