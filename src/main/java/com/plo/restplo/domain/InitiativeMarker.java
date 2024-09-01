package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class InitiativeMarker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;

    private Color color;
    @Setter
    private boolean twoMovesFlag;
    @Setter
    @ManyToOne
    @JoinColumn(name = "ROUND_ID")
    private Round round;

    public InitiativeMarker(Color color) {
        this.color = color;
    }
}
