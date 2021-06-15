package com.pinhobrunodev.brunolanches.mapper;

import org.springframework.stereotype.Component;

import com.pinhobrunodev.brunolanches.dto.ProductDTO;
import com.pinhobrunodev.brunolanches.dto.ProductInsertDTO;
import com.pinhobrunodev.brunolanches.entites.Product;

@Component
public class ProductMapper {

	
	public Product toEntity(ProductInsertDTO dto) {
		Product entity = new Product();
		entity.setId(dto.getId());
		entity.setDescription(dto.getDescription());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		return entity;
	}
	
	public ProductDTO toProductDTO(Product entity) {
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setDescription(entity.getDescription());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		return dto;
	}
}
