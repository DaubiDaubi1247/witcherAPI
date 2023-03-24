package ru.alex.witcherapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.witcherapi.entity.Monster;
import ru.alex.witcherapi.entity.MonsterBase;
import ru.alex.witcherapi.entity.MonsterClass;

import java.util.List;
import java.util.Optional;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {

    List<Monster> findAllByMonsterClass(MonsterClass monsterClass);

    boolean existsByImgSource(String imgSource);

    Optional<MonsterBase> findByImgSource(String imgSource);
}
