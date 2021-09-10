package ru.zhegalov.demo.service;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.zhegalov.demo.domain.IndividualNumber;
import ru.zhegalov.demo.domain.Person;
import ru.zhegalov.demo.repositories.PersonRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
class PersonMapperServiceImplTest {
    @Autowired
    private PersonRepository personRepository;

    private Long personId;

    @BeforeEach
    void setUp() {
        final Person person = new Person().setIndividualNumber(new IndividualNumber().setNumber("some number"));
        final Person save = personRepository.save(person);
        this.personId = save.getId();
    }

    @AfterEach
    void tearDown() {
        personRepository.deleteById(personId);
    }

    @Autowired
    private PersonMapperService personMapperService;

    @Test
    void shouldGetPersonFromRepository() {
        assertThat(personRepository.findById(personId)).isNotEmpty();
    }

    @Test
    void shouldThrowExceptionWhenGetPersonDto() {
        assertThatThrownBy(() -> personMapperService.getPerson(personId))
                .isInstanceOf(LazyInitializationException.class);
    }

}