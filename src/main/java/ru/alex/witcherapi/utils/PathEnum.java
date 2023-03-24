package ru.alex.witcherapi.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PathEnum {
    ROOT_IMG_PATH("src/main/webapp/WEB-INF/img/"),
    ROOT_CLASS_PATH(ROOT_IMG_PATH.path + "class/"),

    PATH_FOR_GET_IMG("/WEB-INF/img/"),
    ;
    private final String path;
}
