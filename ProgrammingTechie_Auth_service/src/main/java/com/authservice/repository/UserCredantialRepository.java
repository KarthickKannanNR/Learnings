package com.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authservice.entity.UserInfo;

@Repository
public interface UserCredantialRepository extends JpaRepository<UserInfo, Integer>{

	Optional<UserInfo> findByName(String username);

}
