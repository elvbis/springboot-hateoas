package com.demo.person.repository.entity;


import lombok.*;
import org.springframework.data.annotation.Id;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class PersonEntity{

	@Id
	private String id;
	
	private String firstName;

	private String lastName;
	


}
