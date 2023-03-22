package ru.alex.witcherapi.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "monster_class")
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class MonsterClass extends MonsterBase {

}
