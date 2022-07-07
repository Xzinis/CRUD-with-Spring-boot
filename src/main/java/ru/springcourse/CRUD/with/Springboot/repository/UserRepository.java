package ru.springcourse.CRUD.with.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.springcourse.CRUD.with.Springboot.models.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
}
