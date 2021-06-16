package com.pinhobrunodev.brunolanches.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pinhobrunodev.brunolanches.entites.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByName(String name);

	Optional<Product> findByNameAndDescriptionAndPrice(String name, String description, Double price);

	Optional<Product> findByNameAndDescription(String name, String description);

	@Query("SELECT obj FROM Product obj WHERE obj.description = :description AND obj.name = :name AND obj.id <> :id")
	Optional<Product> findByProductAndUpdate(Long id, String description, String name);
	
	@Query("SELECT obj FROM Product obj WHERE obj.name = :name AND obj.id <> :id")
	Optional<Product> findByNameAndId(String name, Long id);

}
