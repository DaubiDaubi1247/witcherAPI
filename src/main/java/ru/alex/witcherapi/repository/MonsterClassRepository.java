package ru.alex.witcherapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alex.witcherapi.entity.MonsterClass;

public interface MonsterClassRepository extends JpaRepository<MonsterClass, Long> {
}
