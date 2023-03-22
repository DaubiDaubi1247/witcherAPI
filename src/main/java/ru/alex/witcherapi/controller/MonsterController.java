package ru.alex.witcherapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.witcherapi.dto.MonsterClassDto;
import ru.alex.witcherapi.service.MonsterService;

import java.util.List;

@RestController
@RequestMapping("api/v1.0/monster_class")
@RequiredArgsConstructor
public class MonsterController {

    private final MonsterService monsterService;

    @GetMapping("/all")
    public ResponseEntity<List<MonsterClassDto>> getMonsterClassList() {
        return ResponseEntity.ok(monsterService.getMonsterClassList());
    }
}
