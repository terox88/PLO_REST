package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@DynamicUpdate
@EqualsAndHashCode
@NoArgsConstructor
public class Abilities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    private final int levelOneMaxSize = 2;
    private final int levelTwoMaxSize = 3;
    private final int levelThreeMaxSize = 4;
    private final List<AbilitiesType> levOneAbilitiesTypes = new ArrayList<>();
    private final List<AbilitiesType> levTwoAbilitiesTypes = new ArrayList<>();
    private final List<AbilitiesType> LevThreeAbilitiesTypes = new ArrayList<>();


}
