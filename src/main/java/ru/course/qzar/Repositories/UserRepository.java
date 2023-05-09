package ru.course.qzar.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.course.qzar.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
