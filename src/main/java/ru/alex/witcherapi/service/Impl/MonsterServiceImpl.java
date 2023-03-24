package ru.alex.witcherapi.service.Impl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.dto.UploadFilesWithDescription;
import ru.alex.witcherapi.dto.projection.MonsterWithDescription;
import ru.alex.witcherapi.entity.Monster;
import ru.alex.witcherapi.entity.MonsterBase;
import ru.alex.witcherapi.entity.MonsterClass;
import ru.alex.witcherapi.entity.MonsterDescription;
import ru.alex.witcherapi.exception.FileAlreadyExistsException;
import ru.alex.witcherapi.exception.NotFoundException;
import ru.alex.witcherapi.mapper.MonsterMapper;
import ru.alex.witcherapi.repository.MonsterRepository;
import ru.alex.witcherapi.service.MonsterClassService;
import ru.alex.witcherapi.service.MonsterService;
import ru.alex.witcherapi.utils.FileUtils;
import ru.alex.witcherapi.utils.ImgPaths;

import java.nio.file.Path;
import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class MonsterServiceImpl implements MonsterService {
    private final MonsterRepository monsterRepository;
    private final MonsterMapper monsterMapper;
    private final ImgPaths imgPaths;
    private final MonsterClassService monsterClassService;


    @Override
    @Transactional
    public MonsterBaseDto uploadMonster(Long monsterClassId, @Valid UploadFilesWithDescription monsterInfo,
                                        @NotNull MultipartFile monsterImg) {

        MonsterClass monsterClass = monsterClassService.getMonsterClassById(monsterClassId);
        String monsterImgPath = monsterImg.getOriginalFilename();
        Path saveDirectoryPath = imgPaths.getRootMonsterImgPath();

        if (monsterRepository.existsByImgName(monsterImgPath)) {
            throw new FileAlreadyExistsException("img with path" + monsterImgPath + " not found");
        }
        MonsterDescription monsterDescription = MonsterDescription.builder()
                        .description(monsterInfo.getDescription())
                        .quote(monsterInfo.getQuote())
                        .quoteAuthor(monsterInfo.getQuoteAuthor())
                        .build();

        Monster newMonster = Monster.builder()
                .monsterClass(monsterClass)
                .name(monsterInfo.getName())
                .imgName(monsterImgPath)
                .source("monster/")
                .monsterDescription(monsterDescription)
                .build();

        FileUtils.saveFile(monsterImg, saveDirectoryPath);

        return monsterMapper.toDto(monsterRepository.save(newMonster));
    }

    @Override
    @Transactional
    public List<MonsterWithDescription> getMonsterListByClassId(Long id) {
        MonsterClass monsterClass = monsterClassService.getMonsterClassById(id);

        return monsterRepository.findAllByMonsterClass(monsterClass);
    }

    @Override
    public MonsterBase findByPath(String path) {
        return monsterRepository.findByImgName(path)
                .orElseThrow(() -> new NotFoundException("img with path " + path + " not found in monster directory"));
    }
}
