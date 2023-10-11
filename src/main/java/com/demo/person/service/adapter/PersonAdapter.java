package com.demo.person.service.adapter;

import com.demo.person.domain.PersonIn;
import com.demo.person.domain.PersonOut;
import com.demo.person.repository.entity.PersonEntity;
import org.springframework.hateoas.CollectionModel;

import java.util.List;

public interface PersonAdapter {

    List<PersonOut> toListDocumentOut (List<PersonEntity>  documentEntity);

    PersonEntity toEntityDocument(PersonIn personIn);

    PersonOut toPersonOut (PersonEntity personEntity);

    CollectionModel<PersonOut> toCollectionModel(Iterable<? extends PersonEntity> entities);
}
