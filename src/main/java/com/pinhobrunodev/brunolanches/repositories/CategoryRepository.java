package com.pinhobrunodev.brunolanches.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinhobrunodev.brunolanches.entites.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
