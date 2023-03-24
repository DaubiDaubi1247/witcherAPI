package ru.alex.witcherapi.utils;

import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ImgPaths {
    public Path getRootImgPath() {
        return Paths.get(PathEnum.ROOT_IMG_PATH.getPath());
    }

    public Path getRootClassImgPath() {
        return Paths.get(PathEnum.ROOT_CLASS_PATH.getPath());
    }

    public Path getRootMonsterImgPath() {
        return Paths.get(PathEnum.ROOT_MONSTER_PATH.getPath());
    }
}
