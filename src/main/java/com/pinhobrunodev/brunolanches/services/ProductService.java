package com.pinhobrunodev.brunolanches.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinhobrunodev.brunolanches.dto.ProductDTO;
import com.pinhobrunodev.brunolanches.dto.ProductInsertDTO;
import com.pinhobrunodev.brunolanches.entites.Product;
import com.pinhobrunodev.brunolanches.mapper.ProductMapper;
import com.pinhobrunodev.brunolanches.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	@Autowired
	private ProductMapper mapper;
	
	@Transactional
	public ProductDTO insert (ProductInsertDTO dto) {
		Product entity = mapper.toEntity(dto);
		repository.save(entity);
		return mapper.toProductDTO(entity);
	}
	
	@Transactional
	public ProductDTO update (ProductInsertDTO dto) {
		Product entity = mapper.toEntity(dto);
		repository.save(entity);
		return mapper.toProductDTO(entity);
	}

	
	@Transactional
	public void delete (Long id) {
	repository.deleteById(id);
	}


	@Transactional(readOnly = true)
	public List<ProductDTO> findAllProducts() {
		return repository.findAll().stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ProductDTO findProductByName(String name) {
		return new ProductDTO(repository.findByName(name));

	}

	@Transactional(readOnly = true)
	public ProductDTO findProductById(Long id) {
		return repository.findById(id).map(x -> new ProductDTO(x)).orElseThrow(IllegalArgumentException::new);
	}
}
