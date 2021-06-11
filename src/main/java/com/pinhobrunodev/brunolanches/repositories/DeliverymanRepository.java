package com.pinhobrunodev.brunolanches.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pinhobrunodev.brunolanches.entites.Deliveryman;

@Repository
public interface DeliverymanRepository extends JpaRepository<Deliveryman, Long> {

	@Query("SELECT obj FROM Deliveryman  obj ORDER BY obj.name ASC")
	List<Deliveryman> findAllOrderByNameASC();

	Optional<Deliveryman> findByEmail(String email);

	Optional<Deliveryman> findByNameAndPhoneAndEmailAndCpf(String name, String phone, String email, String cpf);

	Optional<Deliveryman> findByPhone(String phone);

	Optional<Deliveryman> findByCpf(String cpf);

	@Query("SELECT obj FROM Deliveryman obj WHERE obj.cpf = :cpf AND obj.email = :email AND obj.name = :name AND obj.phone = :phone AND obj.id <> :id")
	Optional<Deliveryman> findDeliverymanAndUpdate(Long id, String cpf, String email, String name, String phone);

	@Query("SELECT obj FROM Deliveryman obj WHERE obj.cpf = :cpf AND obj.id <> :id")
	Optional<Deliveryman> findByCpfAndId(Long id, String cpf);

	@Query("SELECT obj FROM Deliveryman obj WHERE obj.email = :email AND obj.id <> :id")
	Optional<Deliveryman> findByEmailAndId(Long id, String email);

	@Query("SELECT obj FROM Deliveryman obj WHERE obj.phone = :phone AND phone.id <> :id")
	Optional<Deliveryman> findByPhoneAndId(Long id, String phone);
	
	@Query("SELECT DISTINCT obj FROM Deliveryman obj JOIN FETCH obj.orders o WHERE o.status = 0 AND obj.id = :id")
	List<Deliveryman> findAllOrdersByDeliverymaIdDelivered(Long id);
	
	@Query("SELECT DISTINCT obj FROM Deliveryman obj JOIN FETCH obj.orders o WHERE o.status = 1 AND obj.id = :id")
	List<Deliveryman> findAllOrdersByDeliverymaIdPending(Long id);

}
