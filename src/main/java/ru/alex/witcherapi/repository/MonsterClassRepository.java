package ru.alex.witcherapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.witcherapi.entity.MonsterBase;
import ru.alex.witcherapi.entity.MonsterClass;

import java.util.Optional;

@Repository
public interface MonsterClassRepository extends JpaRepository<MonsterClass, Long> {
    boolean existsByNameAndImgName(String name, String imgSource);

    Optional<MonsterBase> findByImgName(String imgSource);
}
