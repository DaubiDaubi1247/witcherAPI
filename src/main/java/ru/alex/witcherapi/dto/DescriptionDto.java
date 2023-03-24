package ru.alex.witcherapi.dto;

import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class DescriptionDto {
    @Lob
    private String quote;

    private String quoteAuthor;

    @Lob
    private String description;
}
