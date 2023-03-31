package ru.alex.witcherapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.witcherapi.entity.ImgDirection;

import java.util.Optional;

@Repository
public interface ImgRepository extends JpaRepository<ImgDirection, Long> {

    Optional<ImgDirection> findByName(String name);
}
