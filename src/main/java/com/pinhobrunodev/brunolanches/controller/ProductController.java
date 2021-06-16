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

import com.pinhobrunodev.brunolanches.dto.ProductDTO;
import com.pinhobrunodev.brunolanches.dto.ProductInsertDTO;
import com.pinhobrunodev.brunolanches.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> insert(@RequestBody ProductInsertDTO dto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(service.insert(dto));
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> update(@RequestBody ProductInsertDTO dto) {
		return ResponseEntity.ok().body(service.update(dto));

	}

	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> findAllProducts() {
		return ResponseEntity.ok().body(service.findAllProducts());
	}

	@GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> findProductByName(@PathVariable String name) {
		return ResponseEntity.ok().body(service.findProductByName(name));
	}

	@GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> findProductById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findProductById(id));
	}

}
