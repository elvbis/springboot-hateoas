package com.demo.person.service.adapter.impl;

import com.demo.person.domain.PersonIn;
import com.demo.person.domain.PersonOut;
import com.demo.person.repository.entity.PersonEntity;
import com.demo.person.resource.PersonResource;
import com.demo.person.service.adapter.PersonAdapter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PersonAdapterImpl extends RepresentationModelAssemblerSupport<PersonEntity, PersonOut> implements PersonAdapter {
    public PersonAdapterImpl() {
        super(PersonResource.class, PersonOut.class);
    }

    @Override
    public CollectionModel<PersonOut> toCollectionModel(Iterable<? extends PersonEntity> entities)
    {
        CollectionModel<PersonOut> actorModels = super.toCollectionModel(entities);
        actorModels.add(linkTo(methodOn(PersonResource.class).getAllPersons()).withSelfRel());
        return actorModels;
    }
    @Override
    public List<PersonOut> toListDocumentOut(List<PersonEntity>  list) {


        List<PersonOut> listReturn = new ArrayList<>();
        for(PersonEntity en : list){
           listReturn.add(toModel(en));
        }
        return listReturn;
    }

    @Override
    public PersonEntity toEntityDocument(PersonIn personIn) {
        PersonEntity entity = new PersonEntity();
        entity.setFirstName(personIn.getFirstName());
        entity.setLastName(personIn.getLastName());
        entity.setId(personIn.getId());
        return entity;
    }

    @Override
    public PersonOut toPersonOut(PersonEntity personEntity) {
        return toModel(personEntity);
    }

    @Override
    public PersonOut toModel(PersonEntity entity) {
        PersonOut out = new PersonOut();
        out.setFirstName(entity.getFirstName());
        out.setLastName(entity.getLastName());
        out.setId(entity.getId());
        out.add(linkTo(methodOn(PersonResource.class).getPersonById(entity.getId()))
                .withSelfRel());
        return out;
    }
}
