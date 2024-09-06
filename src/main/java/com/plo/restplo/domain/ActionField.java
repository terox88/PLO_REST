package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayDeque;
import java.util.Queue;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@DynamicUpdate
public class ActionField {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    private  ActionFieldType actionFieldType;
    @OneToMany(
            targetEntity = ActionMarker.class,
            mappedBy = "actionField",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private  Queue<ActionMarker> actionMarkers = new ArrayDeque<>();
    private  int maxTrackSize;
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private  Board board;

    public ActionField(ActionFieldType actionFieldType, int maxTrackSize) {
        this.actionFieldType = actionFieldType;
        this.maxTrackSize = maxTrackSize;

    }
}
