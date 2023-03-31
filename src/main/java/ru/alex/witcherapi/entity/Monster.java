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
    @JoinColumn(name = "monster_class_id")
    private MonsterClass monsterClass;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "monster_desc_id")
    private MonsterDescription monsterDescription;
}
