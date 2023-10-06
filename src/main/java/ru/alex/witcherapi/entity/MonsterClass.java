package ru.alex.witcherapi.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "monster_class")
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class MonsterClass extends MonsterBase {

    @OneToMany(mappedBy = "monsterClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Monster> monsterList = new ArrayList<>();

}
