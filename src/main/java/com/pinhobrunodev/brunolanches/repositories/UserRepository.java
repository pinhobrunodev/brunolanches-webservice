package com.pinhobrunodev.brunolanches.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pinhobrunodev.brunolanches.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	@Query("SELECT obj FROM User obj ORDER BY obj.date ASC")
	List<User>findAllByBirthDateOrderASC();
	
	@Query("SELECT obj FROM User obj WHERE obj.name = :name")
	User findByName(String name);

}
