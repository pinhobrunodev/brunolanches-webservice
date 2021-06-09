package com.pinhobrunodev.brunolanches.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pinhobrunodev.brunolanches.entites.Deliveryman;

@Repository
public interface DeliverymanRepository extends JpaRepository<Deliveryman, Long> {

	
	@Query("SELECT obj FROM Deliveryman  obj ORDER BY obj.name ASC")
	List<Deliveryman> findAllOrderByNameASC();

	Deliveryman findByEmail(String email);

}
