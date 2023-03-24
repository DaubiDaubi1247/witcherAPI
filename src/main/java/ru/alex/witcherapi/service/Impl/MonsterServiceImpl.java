package ru.alex.witcherapi.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.entity.MonsterBase;
import ru.alex.witcherapi.entity.MonsterClass;
import ru.alex.witcherapi.exception.NotFoundException;
import ru.alex.witcherapi.mapper.MonsterMapper;
import ru.alex.witcherapi.repository.MonsterRepository;
import ru.alex.witcherapi.service.MonsterClassService;
import ru.alex.witcherapi.service.MonsterService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class MonsterServiceImpl implements MonsterService {
    private final MonsterRepository monsterRepository;
    private final MonsterMapper monsterMapper;
    private final MonsterClassService monsterClassService;


    @Override
    @Transactional
    public List<MonsterBaseDto> getMonsterListByClassId(Long id) {
        MonsterClass monsterClass = monsterClassService.getMonsterClassById(id);

        return monsterMapper.toDtoList(monsterRepository.findAllByMonsterClass(monsterClass));
    }

    @Override
    public MonsterBase findByPath(String path) {
        return monsterRepository.findByImgSource(path)
                .orElseThrow(() -> new NotFoundException("img with path " + path + " not found in monster directory"));
    }
}
