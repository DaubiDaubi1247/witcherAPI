package ru.alex.witcherapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.witcherapi.service.ImgService;

@RestController
@RequestMapping("api/v1.0/img")
@RequiredArgsConstructor
public class ImgController {

    private final ImgService imgService;
    @GetMapping(value = "/{source}/{path}",produces = MediaType.IMAGE_PNG_VALUE)
    public Resource getImageByPath(@PathVariable String source, @PathVariable("path") String path) {
        return imgService.getImgByPath(source, path);
    }
}
