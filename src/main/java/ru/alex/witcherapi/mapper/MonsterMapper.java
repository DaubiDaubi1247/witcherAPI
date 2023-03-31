package ru.alex.witcherapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.dto.UploadFilesWithDescription;
import ru.alex.witcherapi.entity.MonsterBase;
import ru.alex.witcherapi.entity.MonsterDescription;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MonsterMapper {

    @Mapping(target = "source", source = "imgDirection.name")
    MonsterBaseDto toDto(MonsterBase monsterBase);

    MonsterDescription toMonsterDescription(UploadFilesWithDescription monsterInfo);

    List<MonsterBaseDto> toDtoList(List<? extends MonsterBase> monsterClassList);

}
