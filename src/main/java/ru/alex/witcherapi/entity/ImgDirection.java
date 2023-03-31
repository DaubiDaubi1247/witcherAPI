package ru.alex.witcherapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "img_direction")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ImgDirection {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotBlank
    private String name;
}
