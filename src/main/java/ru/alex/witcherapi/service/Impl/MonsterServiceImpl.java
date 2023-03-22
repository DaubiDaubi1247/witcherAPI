package ru.alex.witcherapi.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.mapper.MonsterMapper;
import ru.alex.witcherapi.repository.MonsterClassRepository;
import ru.alex.witcherapi.repository.MonsterRepository;
import ru.alex.witcherapi.service.MonsterService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class MonsterServiceImpl implements MonsterService {

    private final MonsterClassRepository monsterClassRepository;
    private final MonsterRepository monsterRepository;
    private final MonsterMapper monsterMapper;

    @Override
    public List<MonsterBaseDto> getMonsterClassList() {
        return monsterMapper.toDtoList(monsterClassRepository.findAll());
    }

    @Override
    public List<MonsterBaseDto> getMonsterList() {
        return monsterMapper.toDtoList(monsterRepository.findAll());
    }
}
