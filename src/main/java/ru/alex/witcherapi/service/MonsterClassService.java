package ru.alex.witcherapi.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.dto.UploadFilesBaseDto;
import ru.alex.witcherapi.entity.MonsterClass;
import ru.alex.witcherapi.utils.PathChecker;

import java.util.List;

public interface MonsterClassService extends PathChecker {
    List<MonsterBaseDto> getMonsterClassList();

    MonsterClass getMonsterClassById(Long id);

    MonsterBaseDto uploadClass(@Valid UploadFilesBaseDto classInfo, @NotNull MultipartFile classImg);

    boolean deleteMonsterClass(Long id);

    boolean updateMonsterClass(Long id, UploadFilesBaseDto updateInfo);
}
