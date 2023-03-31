package ru.alex.witcherapi.service;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.context.support.ServletContextResource;
import ru.alex.witcherapi.entity.ImgDirection;

public interface ImgService {

    ServletContextResource getImgByPath(@NotBlank String source, @NotBlank String path);

    ImgDirection getImgDirectionByName(String name);
}
