package ru.alex.witcherapi.mapper;

import org.mapstruct.Mapper;
import ru.alex.witcherapi.dto.MonsterClassDto;
import ru.alex.witcherapi.entity.MonsterClass;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MonsterClassMapper {
    List<MonsterClassDto> toDtoList(List<MonsterClass> monsterClassList);
}
