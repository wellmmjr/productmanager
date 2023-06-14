package com.github.wellmmjr.productmanager.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import com.github.wellmmjr.productmanager.data.model.Product;
import com.github.wellmmjr.productmanager.data.vo.v1.ProductVO;

public class MockProduct {

	public Product mockEntity() {
    	return mockEntity(0);
    }
    
    public ProductVO mockVO() {
    	return mockVO(0);
    }
    
    public List<Product> mockEntityList() {
        List<Product> persons = new ArrayList<Product>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<ProductVO> mockVOList() {
        List<ProductVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    private Product mockEntity(Integer number) {
    	Product product = new Product();
    	product.setProductHeight(number);
    	product.setProductDepth(number);
    	product.setProductWidth(number);
    	product.setId(number.longValue());
    	product.setProductName("Product Name Test" + number);
        return product;
    }

    private ProductVO mockVO(Integer number) {
    	ProductVO product = new ProductVO();
    	product.setProductHeight(number);
    	product.setProductDepth(number);
    	product.setProductWidth(number);
    	product.setKey(number.longValue());
    	product.setProductName("Product Name Test" + number);
        return product;
    }
}
