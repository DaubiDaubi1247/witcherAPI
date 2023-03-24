package ru.alex.witcherapi.utils;

import jakarta.validation.constraints.NotBlank;
import ru.alex.witcherapi.entity.MonsterBase;

public interface PathChecker {
    MonsterBase findByPath(@NotBlank String path);
}
