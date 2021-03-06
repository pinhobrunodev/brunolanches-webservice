package com.pinhobrunodev.brunolanches.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pinhobrunodev.brunolanches.dto.UserDTO;
import com.pinhobrunodev.brunolanches.dto.UserInsertDTO;
import com.pinhobrunodev.brunolanches.dto.UserOrderDTO;
import com.pinhobrunodev.brunolanches.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> insert(@RequestBody UserInsertDTO dto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(service.insert(dto));
	}

	@PutMapping(value = "/updated", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> update(@RequestBody UserInsertDTO dto) {
		return ResponseEntity.ok().body(service.update(dto));
	}

	@DeleteMapping(value = "/{id}/removed")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{id}/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserOrderDTO>> findAllOrdersByUserId(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findAllOrdersByUserId(id));
	}

	@GetMapping(value = "/{id}/orders/status/pending", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserOrderDTO>> findAllOrderByUserIdStatusPending(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findAllOrderByUserIdStatusPending(id));

	}

	@GetMapping(value = "/{id}/orders/status/delivered", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserOrderDTO>> findAllOrderByUserIdStatusDelivered(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findAllOrderByUserIdStatusDelivered(id));

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDTO>> findAllByBirthDateOrderASC() {
		return ResponseEntity.ok().body(service.findAllByBirthDateOrderASC());
	}

	@GetMapping(value = "/{name}/found", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> findByName(@PathVariable String name) {
		return ResponseEntity.ok().body(service.findByName(name));
	}

}