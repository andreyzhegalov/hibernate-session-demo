package ru.zhegalov.demo.service;

import ru.zhegalov.demo.domain.Person;

import java.util.Optional;

public interface PersonService {

    Optional<Person> getPerson(Long id);

    Person save(Person person);
}
