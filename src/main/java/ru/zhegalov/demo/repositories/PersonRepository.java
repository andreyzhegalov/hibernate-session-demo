package ru.zhegalov.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zhegalov.demo.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
