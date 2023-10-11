package com.demo.person.service;

import com.demo.person.domain.PersonIn;
import com.demo.person.domain.PersonOut;
import org.springframework.hateoas.CollectionModel;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    CollectionModel<PersonOut> getAllPersons();
    void saveNewDocument(PersonIn personIn) throws Exception;
    void save(PersonIn personIn);

    Optional<PersonOut> findById(String id);
}
