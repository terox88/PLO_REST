package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@DynamicUpdate
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
