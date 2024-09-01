package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayDeque;
import java.util.Queue;
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    private int order;
    @OneToMany(
            targetEntity = InitiativeMarker.class,
            mappedBy = "round",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Queue<InitiativeMarker> markers = new ArrayDeque<>();
    private boolean isScoring;
    private int actionMarkersQuantity;
    @ManyToOne
    @JoinColumn(name = "STAGE_ID")
    private Stage stage;

    public Round(int order, boolean isScoring, int actionMarkersQuantity, Stage stage) {
        this.order = order;
        this.isScoring = isScoring;
        this.actionMarkersQuantity = actionMarkersQuantity;
        this.stage = stage;
    }
}
