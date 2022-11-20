package com.demo.example;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Modifying
	@Transactional
	
	@Query(value = "insert into USER (NAME, AGE, DETAILS) values (:name, :age, :details)", nativeQuery = true)
	void saveWithJson(String name, String details, int age);

}
