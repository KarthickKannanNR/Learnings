package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDTO {

	private String firstName;
	private String lastName;
	Long id;
	String empId;
	String countryCode;
	int age;
}
