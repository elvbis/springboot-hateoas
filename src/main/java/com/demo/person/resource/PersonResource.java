package com.demo.person.resource;

import com.demo.person.domain.PersonOut;
import com.demo.person.repository.entity.PersonEntity;
import com.demo.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonResource {


	@Autowired
	private PersonService personService;

	@GetMapping()
	public ResponseEntity<CollectionModel<PersonOut>> getAllPersons() {
		CollectionModel<PersonOut> list = personService.getAllPersons();
		System.out.println("ok");
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersonOut> getPersonById(@PathVariable("id") String id)
	{
		return personService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping()
	public List<PersonEntity> save() {

		System.out.println("ok");
		return null;
	}

}
