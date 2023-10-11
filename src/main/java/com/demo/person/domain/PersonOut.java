package com.demo.person.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonOut extends RepresentationModel<PersonOut> {

	private String id;
	private String firstName;
	private String lastName;

}
