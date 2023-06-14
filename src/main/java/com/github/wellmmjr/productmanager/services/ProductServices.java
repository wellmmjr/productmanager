package com.github.wellmmjr.productmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.wellmmjr.productmanager.converter.DozerConverter;
import com.github.wellmmjr.productmanager.data.model.Product;
import com.github.wellmmjr.productmanager.data.vo.v1.ProductVO;
import com.github.wellmmjr.productmanager.exception.ResourceNotFoundException;
import com.github.wellmmjr.productmanager.repository.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	ProductRepository repository;
	
	public ProductVO createProduct(ProductVO Product) {
		
		var entity = DozerConverter.parseObject(Product, Product.class);
		repository.save(entity);
		var entityVO = DozerConverter.parseObject(entity, ProductVO.class);
		
		
		return entityVO;
	}
	
	public ProductVO updateProduct(ProductVO product) {
		var entity = repository.findById(product.getKey()).
				orElseThrow(() -> new ResourceNotFoundException("no records found for this id")) ;

		entity.setProductDepth(product.getProductDepth());
		entity.setProductHeight(product.getProductHeight());
		entity.setProductWidth(product.getProductWidth());
		entity.setProductName(product.getProductName());
		
		return DozerConverter.parseObject(repository.save(entity), ProductVO.class);
	}

	@Transactional
	public void disableProduct(Long id) {
		repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("no records found for this id")) ;
		
		repository.disableProducts(id);
	}
	
	public void deleteProduct(Long id) {
		Product entity = repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("no records found for this id")) ;
		repository.delete(entity);
	}
	
	public ProductVO findById(Long id) {

		var entity = repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("no records found for this id")) ;
		return DozerConverter.parseObject(entity, ProductVO.class);
	}
	
	
	public Page<ProductVO> findAllByName(String firstName, Pageable pageable) {		
		var page = repository.findProductByName(firstName, pageable);
		return page.map(this::convertToProductVO);
	}
	
	public Page<ProductVO> findAll(Pageable pageable) {
		
		var page = repository.findAll(pageable);
		return page.map(this::convertToProductVO);
	}

	private ProductVO convertToProductVO(Product entity) {
		return DozerConverter.parseObject(entity, ProductVO.class);
	}
	
}
