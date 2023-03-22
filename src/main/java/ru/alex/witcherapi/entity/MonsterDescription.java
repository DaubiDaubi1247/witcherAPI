package ru.alex.witcherapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "monster_desc")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MonsterDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "quote")
    private String quote;

    @Column(name = "quote_author")
    private String quoteAuthor;

    @Lob
    @Column(name = "description")
    private String description;

    @OneToOne(mappedBy = "monsterDescription")
    private Monster monster;
}
