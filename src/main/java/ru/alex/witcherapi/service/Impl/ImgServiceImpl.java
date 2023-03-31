package ru.alex.witcherapi.service.Impl;

import jakarta.servlet.ServletContext;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.context.support.ServletContextResource;
import ru.alex.witcherapi.entity.ImgDirection;
import ru.alex.witcherapi.entity.MonsterBase;
import ru.alex.witcherapi.exception.NotFoundException;
import ru.alex.witcherapi.repository.ImgRepository;
import ru.alex.witcherapi.service.ImgService;
import ru.alex.witcherapi.service.MonsterClassService;
import ru.alex.witcherapi.service.MonsterService;
import ru.alex.witcherapi.utils.ImgSourceEnum;
import ru.alex.witcherapi.utils.PathEnum;

@Service
@RequiredArgsConstructor
@Validated
public class ImgServiceImpl implements ImgService {

    private final ImgRepository imgRepository;

    private final MonsterClassService monsterClassService;
    private final MonsterService monsterService;

    private final ServletContext servletContext;


    @Override
    @Transactional
    public ServletContextResource getImgByPath(@NotBlank String source, @NotBlank String path) {

        MonsterBase monsterBase;

        switch (ImgSourceEnum.valueOf(source.toUpperCase())) {
            case CLASS -> monsterBase = monsterClassService.findByPath(path);
            case MONSTER -> monsterBase = monsterService.findByPath(path);

            default -> throw new NotFoundException("source with name = " + source + " not found");
        }

        return new ServletContextResource(servletContext,
                PathEnum.PATH_FOR_GET_IMG.getPath() + monsterBase.getImgDirection().getName() + monsterBase.getImgName());
    }

    @Override
    public ImgDirection getImgDirectionByName(String name) {
        return imgRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("direction with name = " + name + " not found"));
    }
}
