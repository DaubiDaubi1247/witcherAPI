package ru.alex.witcherapi.service.Impl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;
import ru.alex.witcherapi.dto.MonsterBaseDto;
import ru.alex.witcherapi.dto.UploadFilesBaseDto;
import ru.alex.witcherapi.entity.MonsterBase;
import ru.alex.witcherapi.entity.MonsterClass;
import ru.alex.witcherapi.exception.FileAlreadyExistsException;
import ru.alex.witcherapi.exception.NotFoundException;
import ru.alex.witcherapi.mapper.MonsterMapper;
import ru.alex.witcherapi.repository.MonsterClassRepository;
import ru.alex.witcherapi.service.MonsterClassService;
import ru.alex.witcherapi.utils.ImgPaths;

import java.nio.file.Path;
import java.util.List;

import static ru.alex.witcherapi.utils.FileUtils.saveFile;

@Service
@RequiredArgsConstructor
@Validated
public class MonsterClassServiceImpl implements MonsterClassService {
    private final MonsterClassRepository monsterClassRepository;
    private final MonsterMapper monsterMapper;
    private final ImgPaths imgPaths;

    @Override
    public List<MonsterBaseDto> getMonsterClassList() {
        return monsterMapper.toDtoList(monsterClassRepository.findAll());
    }

    public MonsterClass getMonsterClassById(Long id) {
        return monsterClassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("monster class with id = " + id + " not found"));
    }

    @Override
    @Transactional
    public MonsterBaseDto uploadClass(@Valid UploadFilesBaseDto classInfo, @NotNull MultipartFile classImg) {
        String className = classInfo.getName();

        Path classImgPath = imgPaths.getRootClassImgPath();
        String savedImgSrc = classImg.getOriginalFilename();

        if (monsterClassRepository.existsByNameAndImgName(className,savedImgSrc)) {
            throw new FileAlreadyExistsException("file with name" + classImg.getOriginalFilename() +
                    " already exist");
        }
        MonsterClass newMonsterClass = new MonsterClass();
        newMonsterClass.setName(className);
        newMonsterClass.setImgName(savedImgSrc);
//        newMonsterClass.setSource("class/");

        saveFile(classImg, classImgPath);

        return monsterMapper.toDto(monsterClassRepository.save(newMonsterClass));
    }

    @Override
    public MonsterBase findByPath(String path) {
        return monsterClassRepository.findByImgName(path)
                .orElseThrow(() -> new NotFoundException("img with path " + path + " not found in class directory"));
    }
}
