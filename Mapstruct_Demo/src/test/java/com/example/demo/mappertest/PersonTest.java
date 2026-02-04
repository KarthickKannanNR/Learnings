package com.example.demo.mappertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.PersonDBObject;
import com.example.demo.mapper.PersonMaper;


public class PersonTest {

	@Test
	public void mappingTest() {
		PersonDBObject dbObject = new PersonDBObject();
		dbObject.setId(1L);
		dbObject.setFirstName("karthick");
		dbObject.setDob(new Date(98,6,29));
		
		PersonDTO personDTO = PersonMaper.INSTANCE.toDTO(dbObject);
		System.out.println(personDTO);
		
		assertNull(personDTO.getId());
		assertEquals(personDTO.getLastName(), "");
		assertEquals(personDTO.getCountryCode(), "IN");
	}

}
