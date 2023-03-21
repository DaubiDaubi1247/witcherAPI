package ru.alex.witcherapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "monster")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "img_source")
    private String imgSource;
}
