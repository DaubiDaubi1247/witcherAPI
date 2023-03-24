package ru.alex.witcherapi.utils;

import ru.alex.witcherapi.exception.NotFoundException;

public class FileUtils {

    public static void isFileExists(PathChecker pathChecker, String path) {
        if (!pathChecker.existsByPath(path)) {
            throw new NotFoundException("");
        }
    }
}
