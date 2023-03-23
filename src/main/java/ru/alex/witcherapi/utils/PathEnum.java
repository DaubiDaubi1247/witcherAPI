package ru.alex.witcherapi.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PathEnum {
    ROOT_IMG_PATH("/WEB-INF/img/"),
    ROOT_CLASS_PATH(ROOT_IMG_PATH.path + "class/")
    ;
    private final String path;
}
