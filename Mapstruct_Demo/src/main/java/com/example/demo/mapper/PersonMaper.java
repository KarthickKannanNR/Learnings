package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.PersonDBObject;

@Mapper
public interface PersonMaper {
	
	PersonMaper INSTANCE = Mappers.getMapper(PersonMaper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "lastName", defaultValue = "")
	@Mapping(target = "countryCode", constant = "IN")
	public PersonDTO toDTO(PersonDBObject person);
}
