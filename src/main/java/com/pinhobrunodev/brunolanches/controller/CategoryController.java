package com.pinhobrunodev.brunolanches.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinhobrunodev.brunolanches.dto.CategoryDTO;
import com.pinhobrunodev.brunolanches.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryDTO>> findAllCategories() {
		return ResponseEntity.ok().body(service.findAllCategories());
	}

	@GetMapping(value = "/findBy/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryDTO> findCategoryById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findCategoryById(id));
	}

	@GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryDTO> findCategoryByName(@PathVariable String name) {
		return ResponseEntity.ok().body(service.findCategoryByName(name));
	}

}
