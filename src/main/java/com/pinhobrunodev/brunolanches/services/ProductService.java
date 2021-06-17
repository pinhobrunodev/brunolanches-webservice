package com.pinhobrunodev.brunolanches.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinhobrunodev.brunolanches.dto.CategoryDTO;
import com.pinhobrunodev.brunolanches.dto.ProductDTO;
import com.pinhobrunodev.brunolanches.entites.Category;
import com.pinhobrunodev.brunolanches.entites.Product;
import com.pinhobrunodev.brunolanches.exceptions.product.ExceptionProductBusiness;
import com.pinhobrunodev.brunolanches.exceptions.product.ExceptionProductNotFound;
import com.pinhobrunodev.brunolanches.mapper.ProductMapper;
import com.pinhobrunodev.brunolanches.repositories.CategoryRepository;
import com.pinhobrunodev.brunolanches.repositories.ProductRepository;
import com.pinhobrunodev.brunolanches.utils.ProductMessageUtils;

@Service
public class ProductService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository repository;
	@Autowired
	private ProductMapper mapper;

	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Optional<Product> validationInsert = repository.findByNameAndDescriptionAndPrice(dto.getName().toUpperCase(),
				dto.getDescription().toUpperCase(), dto.getPrice());
		Optional<Product> validationInsertNameAndDescription = repository
				.findByNameAndDescription(dto.getName().toUpperCase(), dto.getDescription().toUpperCase());
		if (dto.getPrice() <= 0) {
			throw new ExceptionProductBusiness(ProductMessageUtils.INVALID_PRICE);
		}
		if (validationInsert.isPresent()) {
			throw new ExceptionProductBusiness(ProductMessageUtils.PRODUCT_ALREADY_EXISTS);
		}
		if (validationInsertNameAndDescription.isPresent()) {
			throw new ExceptionProductBusiness(ProductMessageUtils.PRODUCT_ALREADY_EXISTS);
		}
		Product aux = repository.findByName(dto.getName().toUpperCase());
		if (aux != null) {
			throw new ExceptionProductBusiness(ProductMessageUtils.PRODUCT_ALREADY_EXISTS);
		}

		Product entity = mapper.toEntity(dto);

		for (CategoryDTO x : dto.getCategories()) {
			Category category = categoryRepository.getOne(x.getId());
			entity.getCategories().add(category);
		}
		repository.save(entity);
		return new ProductDTO(entity);
	}

	@Transactional
	public ProductDTO update(ProductDTO dto) {
		Optional<Product> validationInsertUpdate = repository.findByProductAndUpdate(dto.getId(), dto.getDescription(),
				dto.getName());
		Optional<Product> validationInsertNameUpdate = repository.findByNameAndId(dto.getName(), dto.getId());
		if (validationInsertNameUpdate.isPresent()) {
			throw new ExceptionProductBusiness(ProductMessageUtils.PRODUCT_ALREADY_EXISTS);
		}
		if (dto.getPrice() <= 0) {
			throw new ExceptionProductBusiness(ProductMessageUtils.INVALID_PRICE);
		}
		if (validationInsertUpdate.isPresent()) {
			throw new ExceptionProductBusiness(ProductMessageUtils.PRODUCT_ALREADY_EXISTS);
		}
		Product entity = mapper.toEntity(dto);
		for (CategoryDTO x : dto.getCategories()) {
			Category category = categoryRepository.getOne(x.getId());
			entity.getCategories().add(category);
		}
		repository.save(entity);
		return new ProductDTO(entity);
	}

	@Transactional
	public void delete(Long id) {
		Optional<Product> validationIdForDelete = repository.findById(id);
		if (!validationIdForDelete.isPresent()) {
			throw new ExceptionProductNotFound();
		}
		repository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<ProductDTO> findAllProducts() {
		return repository.findAll().stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ProductDTO findProductByName(String name) {

		Product aux = repository.findByName(name.toUpperCase());
		if (aux == null) {
			throw new ExceptionProductNotFound();
		}
		return new ProductDTO(repository.findByName(name.toUpperCase()));

	}

	@Transactional(readOnly = true)
	public ProductDTO findProductById(Long id) {
		return repository.findById(id).map(x -> new ProductDTO(x)).orElseThrow(ExceptionProductNotFound::new);
	}


}
