package ru.alex.witcherapi.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alex.witcherapi.entity.ImgDirection;
import ru.alex.witcherapi.exception.NotFoundException;
import ru.alex.witcherapi.repository.ImgRepository;
import ru.alex.witcherapi.service.ImgDirectionService;

@Service
@RequiredArgsConstructor
public class ImgDirectionServiceImpl implements ImgDirectionService {

    private final ImgRepository imgRepository;

    @Override
    public ImgDirection getImgDirectionByName(String name) {
        return imgRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("direction with name = " + name + " not found"));
    }
}
