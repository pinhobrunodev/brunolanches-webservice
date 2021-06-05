package com.pinhobrunodev.brunolanches.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinhobrunodev.brunolanches.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
