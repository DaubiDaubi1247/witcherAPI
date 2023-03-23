package ru.alex.witcherapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
public class MonsterClassDto {

    @NotBlank(message = "name must be not null or not empty")
    private String name;

    @NotBlank(message = "img cant be null or empty")
    private MultipartFile classImg;

}
