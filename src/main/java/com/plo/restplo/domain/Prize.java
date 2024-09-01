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
public class Prize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;

    private PrizeToken prizeType;
    private int quantity;
    @Setter
    private boolean wasTaken;

    public Prize(PrizeToken prizeType, int quantity) {
        this.prizeType = prizeType;
        this.quantity = quantity;
    }
}
