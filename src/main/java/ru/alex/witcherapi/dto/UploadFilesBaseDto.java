package ru.alex.witcherapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UploadFilesBaseDto {

    @NotBlank(message = "name must be not null or not empty")
    private String name;

}
