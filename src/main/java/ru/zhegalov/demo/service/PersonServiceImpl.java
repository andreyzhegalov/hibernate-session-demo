package ru.zhegalov.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zhegalov.demo.domain.Person;
import ru.zhegalov.demo.repositories.PersonRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Person> getPerson(Long id) {
        return Optional.of(personRepository.getById(id));
    }

    @Transactional
    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }
}
