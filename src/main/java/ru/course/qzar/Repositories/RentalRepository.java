package ru.course.qzar.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.course.qzar.Models.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

}
