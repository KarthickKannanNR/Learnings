package com.example.demo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDBObject {

	private Long id;
	private String firstName;
	private String lastName;
	private Date dob;
	private String empId;
}
