package com.pinhobrunodev.brunolanches.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pinhobrunodev.brunolanches.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT obj FROM User obj ORDER BY obj.date ASC")
	List<User> findAllByBirthDateOrderASC();

	Optional<User> findByName(String name);

	Optional<User> findByNameAndCpfAndEmailAndPhone(String name, String cpf, String email, String phone);

	Optional<User> findByEmail(String email);

	Optional<User> findByPhone(String phone);

	Optional<User> findByCpf(String cpf);

	@Query("SELECT obj FROM User obj WHERE obj.name = :name  AND obj.email = :email AND obj.phone = :phone AND obj.id <> :id")
	Optional<User> findUserAndUpdate(Long id, String name, String email, String phone);

	@Query("SELECT obj FROM User obj WHERE obj.email = :email AND obj.id <> :id")
	Optional<User> findByEmailAndId(String email, Long id);

	@Query("SELECT obj FROM User obj WHERE obj.phone = :phone AND obj.id <> :id")
	Optional<User> findByPhoneAndId(String phone, Long id);

	@Query("SELECT obj FROM User obj WHERE obj.cpf = :cpf AND obj.id <> :id")
	Optional<User> findByCpfAndId(String cpf, Long id);

	Optional<User> findByAddressAndNumber(String address, String number);

	@Query("SELECT obj FROM User obj WHERE obj.address = :address AND obj.number = :number AND obj.id <> :id")
	Optional<User> findByAddressAndNumberAndId(String address, String number, Long id);

	@Query("SELECT DISTINCT obj FROM User obj JOIN FETCH obj.orders WHERE obj.id = :id")
	List<User> findAllOrdersByUserId(Long id);

	@Query("SELECT DISTINCT obj FROM User obj JOIN FETCH obj.orders o WHERE o.status = 0 AND obj.id = :id")
	List<User> findAllOrderByUserIdStatusDelivered(Long id);

	@Query("SELECT DISTINCT obj FROM User obj JOIN FETCH obj.orders o WHERE o.status = 1 AND obj.id = :id ")
	List<User> findAllOrderByUserIdStatusPending(Long id);

}
