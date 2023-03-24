package ru.alex.witcherapi.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.utils.PathChecker;

import java.util.List;

public interface MonsterService extends PathChecker {

    void uploadMonster(@NotBlank String name, Long monsterClass, @NotNull MultipartFile monsterImg);

    List<MonsterBaseDto> getMonsterListByClassId(Long id);
}
