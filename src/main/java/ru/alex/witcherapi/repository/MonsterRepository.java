package ru.alex.witcherapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.witcherapi.entity.Monster;
import ru.alex.witcherapi.entity.MonsterClass;

import java.util.List;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {

    List<Monster> findAllByMonsterClass(MonsterClass monsterClass);

    boolean existsByImgSource(String imgSource);
}
