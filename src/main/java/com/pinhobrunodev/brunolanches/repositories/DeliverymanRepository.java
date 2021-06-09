package com.pinhobrunodev.brunolanches.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinhobrunodev.brunolanches.entites.Deliveryman;

@Repository
public interface DeliverymanRepository extends JpaRepository<Deliveryman, Long> {

}
