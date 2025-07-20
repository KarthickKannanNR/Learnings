package com.example.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

	private int id;
	private String name;
	private int age;
	private String emailAddress;
	private int projectId;
	private Date creationDate;
}
