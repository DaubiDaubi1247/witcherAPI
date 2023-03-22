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
public class Monster extends MonsterBaseClass {

    @OneToOne
    @JoinColumn(name = "monster_desc_id")
    private MonsterDescription monsterDescription;
}
