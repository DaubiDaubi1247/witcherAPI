package ru.alex.witcherapi.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.entity.MonsterClass;
import ru.alex.witcherapi.exception.NotFoundException;
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
    @Transactional
    public List<MonsterBaseDto> getMonsterListByClassId(Long id) {
        MonsterClass monsterClass = getMonsterClassById(id);

        return monsterMapper.toDtoList(monsterRepository.findAllByMonsterClass(monsterClass));
    }

    private MonsterClass getMonsterClassById(Long id) {
        return monsterClassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("monster class with id = " + id + " not found"));
    }
}
