package ru.zhegalov.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zhegalov.test.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
