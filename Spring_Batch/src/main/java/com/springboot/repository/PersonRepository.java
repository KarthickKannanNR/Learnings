package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
