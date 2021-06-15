package com.pinhobrunodev.brunolanches.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinhobrunodev.brunolanches.entites.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
