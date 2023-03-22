package ru.alex.witcherapi.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.alex.witcherapi.dto.MonsterClassDto;
import ru.alex.witcherapi.repository.MonsterClassRepository;
import ru.alex.witcherapi.service.MonsterService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class MonsterServiceImpl implements MonsterService {

    private final MonsterClassRepository monsterClassRepository;

    @Override
    public List<MonsterClassDto> getMonsterClassList() {
        return null;
    }
}
