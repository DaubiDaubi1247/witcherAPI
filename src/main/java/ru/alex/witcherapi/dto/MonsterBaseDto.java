package ru.alex.witcherapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class MonsterBaseDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String imgName;

    private String source;

}
