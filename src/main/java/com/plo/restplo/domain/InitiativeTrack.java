package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@DynamicUpdate
public class InitiativeTrack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @OneToMany(
            targetEntity = InitiativeTrack.class,
            mappedBy = "initiativeTrack",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private  List<Stage> stages;

    public InitiativeTrack(List<Stage> stages) {
        this.stages = stages;
    }
}
