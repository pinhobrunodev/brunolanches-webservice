package com.pinhobrunodev.brunolanches.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinhobrunodev.brunolanches.dto.CategoryDTO;
import com.pinhobrunodev.brunolanches.entites.Category;
import com.pinhobrunodev.brunolanches.exceptions.ExceptionCategoryNotFound;
import com.pinhobrunodev.brunolanches.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAllCategories(){
		return repository.findAll().stream().map(x->new CategoryDTO(x)).collect(Collectors.toList());
	}
	@Transactional(readOnly = true)
	public CategoryDTO findCategoryById(Long id) {
		return repository.findById(id).map(x->new CategoryDTO(x)).orElseThrow(ExceptionCategoryNotFound::new);
	}
	@Transactional(readOnly = true)
	public CategoryDTO findCategoryByName(String name) {
		Category validation = repository.findByName(name.toUpperCase());
		if(validation == null) {
			throw new ExceptionCategoryNotFound();
		}
		return new CategoryDTO(repository.findByName(name.toUpperCase()));
	}
	
	
}
