package ru.alex.witcherapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UploadFilesBaseDto {

    @NotBlank(message = "name must be not null or not empty")
    private String name;

    @NotNull(message = "img cant be null")
    private MultipartFile classImg;

}
