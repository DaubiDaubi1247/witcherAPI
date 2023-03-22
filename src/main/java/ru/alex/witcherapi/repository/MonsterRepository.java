package ru.alex.witcherapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.witcherapi.entity.Monster;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {
}
