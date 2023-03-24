package ru.alex.witcherapi.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.dto.UploadFilesWithDescription;
import ru.alex.witcherapi.utils.PathChecker;

import java.util.List;

public interface MonsterService extends PathChecker {

    MonsterBaseDto uploadMonster(Long monsterClass, @Valid UploadFilesWithDescription monsterInfo,
                                 @NotNull MultipartFile monsterImg);

    List<MonsterBaseDto> getMonsterListByClassId(Long id);
}
