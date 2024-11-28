package com.springboot.postgres.api.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="demo_table")
@Getter
@Setter
public class Ticket {
	
	@Id
	@GeneratedValue
	private int id;
	private String category;
	private double amount;

}
