package ru.alex.witcherapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.alex.witcherapi.dto.projection.MonsterWithDescription;
import ru.alex.witcherapi.entity.Monster;
import ru.alex.witcherapi.entity.MonsterBase;
import ru.alex.witcherapi.entity.MonsterClass;

import java.util.List;
import java.util.Optional;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {

    @Query(" SELECT m " +
            "FROM Monster m " +
            "where m.monsterClass = ?1")
    List<MonsterWithDescription> findAllByMonsterClass(MonsterClass monsterClass);

    boolean existsByImgName(String imgSource);

    Optional<MonsterBase> findByImgName(String imgSource);
}
