package ru.alex.witcherapi.utils;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    public static void saveFile(MultipartFile classImg, Path classImgPath) {
        try {
            Files.copy(classImg.getInputStream(), classImgPath.resolve(classImg.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
