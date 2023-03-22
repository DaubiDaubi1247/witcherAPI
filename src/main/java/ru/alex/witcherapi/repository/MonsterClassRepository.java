package ru.alex.witcherapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.witcherapi.entity.MonsterClass;

@Repository
public interface MonsterClassRepository extends JpaRepository<MonsterClass, Long> {
}
