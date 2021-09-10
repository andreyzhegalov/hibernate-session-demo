package ru.zhegalov.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.zhegalov.demo.domain.Person;
import ru.zhegalov.demo.dto.PersonDto;


@Service
@RequiredArgsConstructor
public class PersonMapperServiceImpl implements PersonMapperService {
    private final PersonService personService;

    @Override
    public PersonDto getPerson(Long id) {
        final Person person = personService.getPerson(id).orElseThrow(RuntimeException::new);
        // Get lazy individual number. Should be LazyInitializationException
        return new PersonDto().setNumber(person.getIndividualNumber().getNumber());
    }
}
