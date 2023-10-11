package com.demo.person.repository;

import com.demo.person.repository.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<PersonEntity, String> {
    List<PersonEntity> findByFirstName(String firstName);

}
