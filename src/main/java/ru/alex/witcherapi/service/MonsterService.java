package ru.alex.witcherapi.service;

import ru.alex.witcherapi.dto.MonsterBaseDto;

import java.util.List;

public interface MonsterService {

    List<MonsterBaseDto> getMonsterListByClassId(Long id);
}
