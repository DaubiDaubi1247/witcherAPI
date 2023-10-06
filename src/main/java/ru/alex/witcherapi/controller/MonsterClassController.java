package ru.alex.witcherapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.dto.UploadFilesBaseDto;
import ru.alex.witcherapi.service.MonsterClassService;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/monster/class")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MonsterClassController {

    private final MonsterClassService monsterService;

    @GetMapping("/all")
    public ResponseEntity<List<MonsterBaseDto>> getMonsterClassList() {
        return ResponseEntity.ok(monsterService.getMonsterClassList());
    }

    @PostMapping
    public ResponseEntity<MonsterBaseDto> uploadCLass(UploadFilesBaseDto classInfo,
                                                      @RequestParam MultipartFile classImg) {

        return ResponseEntity.status(HttpStatus.CREATED).body(monsterService.uploadClass(classInfo, classImg));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteMonsterClass(@PathVariable Long id) {
        return monsterService.deleteMonsterClass(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean updateMonsterClass(@PathVariable Long id, @RequestBody UploadFilesBaseDto updateInfo) {
        return monsterService.updateMonsterClass(id, updateInfo);
    }
}
