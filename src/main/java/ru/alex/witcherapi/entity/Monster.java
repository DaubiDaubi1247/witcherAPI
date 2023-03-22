package ru.alex.witcherapi.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "monster")
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Monster extends MonsterBase {

    @ManyToOne
    private MonsterClass monsterClass;

    @OneToOne
    @JoinColumn(name = "monster_desc_id")
    private MonsterDescription monsterDescription;
}
