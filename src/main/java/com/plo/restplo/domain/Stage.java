package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Entity
@DynamicUpdate
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    private int numberOfRounds;
    private int order;
    @OneToMany(
            targetEntity = Round.class,
            mappedBy = "stage",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Round> rounds = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "INITIATIVE_TRACK_ID")
    private InitiativeTrack initiativeTrack;
    @Setter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "VUKO_PLATE_ID")
    private VukoPlate vukoPlate;



}
