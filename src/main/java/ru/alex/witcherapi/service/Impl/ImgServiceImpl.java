package ru.alex.witcherapi.service.Impl;

import jakarta.servlet.ServletContext;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.context.support.ServletContextResource;
import ru.alex.witcherapi.exception.NotFoundException;
import ru.alex.witcherapi.service.ImgService;
import ru.alex.witcherapi.service.MonsterClassService;
import ru.alex.witcherapi.service.MonsterService;
import ru.alex.witcherapi.utils.FileUtils;
import ru.alex.witcherapi.utils.ImgSourceEnum;
import ru.alex.witcherapi.utils.PathEnum;

@Service
@RequiredArgsConstructor
@Validated
public class ImgServiceImpl implements ImgService {

    private final MonsterClassService monsterClassService;
    private final MonsterService monsterService;

    private final ServletContext servletContext;

    @Override
    public ServletContextResource getImgByPath(@NotBlank String source, @NotBlank String path) {

        switch (ImgSourceEnum.valueOf(source.toUpperCase())) {
            case CLASS -> FileUtils.isFileExists(monsterClassService, path);
            case MONSTER -> FileUtils.isFileExists(monsterService, path);
            default -> throw new NotFoundException("source with name = " + source + " not found");
        }

        return new ServletContextResource(servletContext, PathEnum.PATH_FOR_GET_IMG.getPath() + source + "/" + path);
    }
}
