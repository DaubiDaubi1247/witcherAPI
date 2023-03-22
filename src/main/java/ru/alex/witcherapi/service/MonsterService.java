package ru.alex.witcherapi.service;

import ru.alex.witcherapi.dto.MonsterClassDto;

import java.util.List;

public interface MonsterService {

    List<MonsterClassDto> getMonsterClassList();
}
