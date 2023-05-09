package ru.course.qzar.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.course.qzar.Models.QZarArena;

public interface QZarRepository extends JpaRepository<QZarArena, Integer> {
}
