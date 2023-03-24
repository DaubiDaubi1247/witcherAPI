package ru.alex.witcherapi.dto;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UploadFilesWithDescription extends UploadFilesBaseDto{
    @Lob
    private String quote;

    private String quoteAuthor;

    @Lob
    private String description;
}
