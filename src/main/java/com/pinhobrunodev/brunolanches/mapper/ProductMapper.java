package com.pinhobrunodev.brunolanches.mapper;

import org.springframework.stereotype.Component;

import com.pinhobrunodev.brunolanches.dto.ProductDTO;
import com.pinhobrunodev.brunolanches.entites.Product;

@Component
public class ProductMapper {

	public Product toEntity(ProductDTO dto) {
		Product entity = new Product();
		entity.setId(dto.getId());
		entity.setDescription(dto.getDescription().toUpperCase());
		entity.setName(dto.getName().toUpperCase());
		entity.setPrice(dto.getPrice());
		return entity;
	}

}
