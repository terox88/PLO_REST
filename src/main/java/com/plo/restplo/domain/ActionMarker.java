package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;


@NoArgsConstructor
@Getter
@Entity
@DynamicUpdate
public class ActionMarker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    private Color color;
    public final static int limit = 5;
    @Setter
    @ManyToOne
    @JoinColumn(name = "ACTION_FIELD_ID")
    private ActionField actionField;
    @Setter
    @ManyToOne
    @JoinColumn(name = "VIPER_GORGE_ID")
    private ViperGorge viperGorge;
    @Setter
    @ManyToOne
    @JoinColumn(name = "HERO_CARD_ID")
    private HeroCard heroCard;

    public ActionMarker(Color color) {
        this.color = color;
    }
}
