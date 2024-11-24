package com.telusko.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.telusko.demo.model.Users;

@RepositoryRestResource(collectionResourceRel ="users" ,path = "users")
public interface UserRepositary extends JpaRepository<Users, Integer>{

}
