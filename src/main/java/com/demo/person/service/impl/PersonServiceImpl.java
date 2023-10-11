package com.demo.person.service.impl;

import com.demo.common.NumberUtil;
import com.demo.person.domain.PersonIn;
import com.demo.person.domain.PersonOut;
import com.demo.person.repository.PersonRepository;
import com.demo.person.repository.entity.PersonEntity;
import com.demo.person.service.PersonService;
import com.demo.person.service.adapter.PersonAdapter;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	private static final Logger LOGGER = Logger.getLogger(PersonServiceImpl.class);

	private final PersonRepository personRepository;
	private final PersonAdapter personAdapter;


	@Override
	public void saveNewDocument(PersonIn personIn) throws Exception {
		long cant = personRepository.count();
		String keyTable = NumberUtil.fullLefthZero(String.valueOf(cant+1),3);
		PersonEntity entity = personAdapter.toEntityDocument(personIn);
		entity.setId(keyTable);
		personRepository.save(entity);
	}

	@Override
	public void save(PersonIn personIn) {
		Optional<PersonEntity> entity = personRepository.findById(personIn.getId());

	}

	@Override
	public Optional<PersonOut> findById(String id) {
		Optional<PersonEntity> entity = personRepository.findById(id);
		PersonOut result = personAdapter.toPersonOut(entity.get());
		return Optional.of(result);
	}

	@Override
	public CollectionModel<PersonOut> getAllPersons() {
		List<PersonOut> listReturn = new ArrayList<>();
		List<PersonEntity> list = (List<PersonEntity>) personRepository.findAll();
		return personAdapter.toCollectionModel(list);
	}


}
