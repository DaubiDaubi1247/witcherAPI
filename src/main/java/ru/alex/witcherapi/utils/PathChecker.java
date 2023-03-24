package ru.alex.witcherapi.utils;

import jakarta.validation.constraints.NotBlank;

public interface PathChecker {
    boolean existsByPath(@NotBlank String path);
}
