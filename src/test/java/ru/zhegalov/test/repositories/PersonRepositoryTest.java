package ru.zhegalov.test.repositories;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.zhegalov.test.domain.IndividualNumber;
import ru.zhegalov.test.domain.Person;

import javax.persistence.EntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest(showSql = true)
class PersonRepositoryTest {
    @Autowired
    EntityManager em;

    @Autowired
    private PersonRepository personRepository;

    @Test
    void shouldThrowExceptionForLazyIndividualNumber() {
        final Person person = new Person().setIndividualNumber(new IndividualNumber().setNumber("some number"));
        final Person savedPerson = personRepository.save(person);

        closeSession();

        final Person personFromDb = em.find(Person.class, savedPerson.getId());
        assertThat(personFromDb).isNotNull();

        closeSession();

        assertThatThrownBy(() -> personFromDb.getIndividualNumber().getNumber())
                .isInstanceOf(LazyInitializationException.class);
    }

    private void closeSession() {
        em.flush();
        em.clear();
    }
}