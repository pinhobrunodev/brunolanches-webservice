package com.pinhobrunodev.brunolanches.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinhobrunodev.brunolanches.dto.CategoryDTO;
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
		return repository.findById(id).map(x->new CategoryDTO(x)).orElseThrow(IllegalArgumentException::new);
	}
	@Transactional(readOnly = true)
	public CategoryDTO findCategortByName(String name) {
		return new CategoryDTO(repository.findByName(name));
	}
	
	
}
