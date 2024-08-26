package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayDeque;
import java.util.Queue;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
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

}
