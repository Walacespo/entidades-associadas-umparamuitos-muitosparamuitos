package com.devsuperior.dscatalog.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Optional<Product> result = repository.findById(id);
		Product entity = result.get();
		return new ProductDTO(entity);
	}

	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		
		
		Product product = new Product();
		
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		
		for (CategoryDTO catDto : dto.getCategories()){
			
			Category cat = new Category();
			cat.setId(catDto.getId());
			product.getCategories().add(cat);
		}
		
		product = repository.save(product);
		
		
		return new ProductDTO(product);
	}
}
