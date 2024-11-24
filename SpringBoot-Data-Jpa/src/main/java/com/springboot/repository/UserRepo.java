package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.entity.UserVO;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserVO, Integer> {

	List<UserVO> findByRole(String role);

	// @Query(value = "select u from USERINFO where u.age >: age")
	// @Query("SELECT u FROM USERINFO u WHERE u.age = :age")
	@Query(value = "SELECT u FROM UserVO u WHERE u.age = :age")
	List<UserVO> findAgeUsingJPQL(@Param("age") int age);

	
	@Query(value = "select * from userinfo where age = ?1",nativeQuery = true)
	List<UserVO> findAgeUsingSQL(int age);

	//findAgeUsingMMethodSytax
	List<UserVO> findByAgeGreaterThan(int age);
	
	
	//find average age of user table
	@Query(value = "SELECT AVG(u.age) from UserVO u")
	Optional<Integer> age();

}
