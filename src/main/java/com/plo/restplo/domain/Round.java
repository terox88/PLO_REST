package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    private int orderNumber;
    @OneToMany(
            targetEntity = InitiativeMarker.class,
            mappedBy = "round",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<InitiativeMarker> markers = new ArrayList<>();
    private boolean isScoring;
    private int actionMarkersQuantity;
    @ManyToOne
    @JoinColumn(name = "STAGE_ID")
    private Stage stage;

    public Round(int orderNumber, boolean isScoring, int actionMarkersQuantity, Stage stage) {
        this.orderNumber = orderNumber;
        this.isScoring = isScoring;
        this.actionMarkersQuantity = actionMarkersQuantity;
        this.stage = stage;
    }
}
