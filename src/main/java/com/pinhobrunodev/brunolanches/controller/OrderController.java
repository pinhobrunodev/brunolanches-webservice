package com.pinhobrunodev.brunolanches.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pinhobrunodev.brunolanches.dto.OrderDTO;
import com.pinhobrunodev.brunolanches.dto.OrderInsertDTO;
import com.pinhobrunodev.brunolanches.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderDTO> insert(@RequestBody OrderInsertDTO dto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(service.insert(dto));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrderDTO>> findAllOrdersByInstantASC() {
		return ResponseEntity.ok().body(service.findAllOrdersByInstantASC());
	}

	@GetMapping(value = "/status/pending", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrderDTO>> findAllOrdersByStatusPENDINGOrderByMomentASC() {
		return ResponseEntity.ok().body(service.findAllOrdersByStatusPENDINGOrderByMomentASC());
	}

	@GetMapping(value = "/status/delivered", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrderDTO>> findAllOrdersByStatusDELIVEREDOrderByMomentASC() {
		return ResponseEntity.ok().body(service.findAllOrdersByStatusDELIVEREDOrderByMomentASC());
	}

	@GetMapping(value = "/{id}/found", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	

	
	@PutMapping(value = "/set/{id}/delivered",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderDTO> setDelivered(@PathVariable Long id){
		return ResponseEntity.ok().body(service.setDelivered(id));
	}

}
