package ru.alex.witcherapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.service.MonsterService;

import java.util.List;

@RestController
@RequestMapping("api/v1.0/monster")
@RequiredArgsConstructor
public class MonsterController {

    private final MonsterService monsterService;

    @GetMapping("/all/{classId}")
    public ResponseEntity<List<MonsterBaseDto>> getMonsterListByClassId(@PathVariable Long classId) {
        return ResponseEntity.ok(monsterService.getMonsterListByClassId(classId));
    }
}
