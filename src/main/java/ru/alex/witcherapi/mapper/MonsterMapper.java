package ru.alex.witcherapi.mapper;

import org.mapstruct.Mapper;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.entity.MonsterBaseClass;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MonsterMapper {
    List<MonsterBaseDto> toDtoList(List<? extends MonsterBaseClass> monsterClassList);
}
