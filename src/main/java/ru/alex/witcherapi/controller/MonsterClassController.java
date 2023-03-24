package ru.alex.witcherapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.dto.UploadFilesBaseDto;
import ru.alex.witcherapi.service.MonsterClassService;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/monster/class")
@RequiredArgsConstructor
public class MonsterClassController {

    private final MonsterClassService monsterService;

    @GetMapping("/all")
    public ResponseEntity<List<MonsterBaseDto>> getMonsterClassList() {
        return ResponseEntity.ok(monsterService.getMonsterClassList());
    }

    @PostMapping(produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<Void> uploadCLass(UploadFilesBaseDto classInfo) {

        monsterService.uploadClass(classInfo);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
