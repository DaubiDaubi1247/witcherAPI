package ru.alex.witcherapi.service;

import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.utils.PathChecker;

import java.util.List;

public interface MonsterService extends PathChecker {

    List<MonsterBaseDto> getMonsterListByClassId(Long id);
}
