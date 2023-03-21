package ru.alex.witcherapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "monster_class")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class MonsterClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "img_source")
    private String imgSource;

    @Lob
    @Column(name = "info")
    private String info;
}
