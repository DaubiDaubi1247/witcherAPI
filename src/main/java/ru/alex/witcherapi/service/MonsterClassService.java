package ru.alex.witcherapi.service;

import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.entity.MonsterClass;

import java.util.List;

public interface MonsterClassService {
    List<MonsterBaseDto> getMonsterClassList();

    MonsterClass getMonsterClassById(Long id);
}
