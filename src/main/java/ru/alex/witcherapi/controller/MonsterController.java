package ru.alex.witcherapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.dto.UploadFilesWithDescription;
import ru.alex.witcherapi.dto.projection.MonsterWithDescription;
import ru.alex.witcherapi.service.MonsterService;

import java.util.List;

@RestController
@RequestMapping("api/v1.0/monster")
@RequiredArgsConstructor
public class MonsterController {

    private final MonsterService monsterService;

    @GetMapping("/all/{classId}")
    public ResponseEntity<List<MonsterWithDescription>> getMonsterListByClassId(@PathVariable Long classId) {
        return ResponseEntity.ok(monsterService.getMonsterListByClassId(classId));
    }

    @PostMapping("/{classId}")
    public ResponseEntity<MonsterBaseDto> uploadMonster(@PathVariable Long classId,
                                                        @RequestParam("monsterImg") MultipartFile monsterImg,
                                                        UploadFilesWithDescription monsterInfo) {

        return ResponseEntity.ok(monsterService.uploadMonster(classId, monsterInfo, monsterImg));
    }
}
