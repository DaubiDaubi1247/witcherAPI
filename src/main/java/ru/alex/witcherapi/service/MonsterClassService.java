package ru.alex.witcherapi.service;

import jakarta.validation.Valid;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.dto.UploadFilesBaseDto;
import ru.alex.witcherapi.entity.MonsterClass;
import ru.alex.witcherapi.utils.PathChecker;

import java.util.List;

public interface MonsterClassService extends PathChecker {
    List<MonsterBaseDto> getMonsterClassList();

    MonsterClass getMonsterClassById(Long id);

    void uploadClass(@Valid UploadFilesBaseDto classInfo);

}
