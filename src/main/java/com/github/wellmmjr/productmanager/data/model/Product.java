package com.github.wellmmjr.productmanager.data.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="product") 
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_name", nullable = false, unique = true)
	private Long id;
	
	@Column(name="product_name", nullable = false, length = 50)
	private String productName;
	
	@Column(name="product_height")
	private int productHeight;
	
	@Column(name="product_width")
	private int productWidth;
	
	@Column(name="product_depth")
	private int productDepth;
	
	@Column(length = 20)
	private Boolean enabled;
	
	
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Product() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductHeight() {
		return productHeight;
	}

	public void setProductHeight(int productHeight) {
		this.productHeight = productHeight;
	}

	public int getProductWidth() {
		return productWidth;
	}

	public void setProductWidth(int productWidth) {
		this.productWidth = productWidth;
	}

	public int getProductDepth() {
		return productDepth;
	}

	public void setProductDepth(int productDepth) {
		this.productDepth = productDepth;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(enabled, id, productDepth, productHeight, productName, productWidth);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(enabled, other.enabled) && Objects.equals(id, other.id)
				&& productDepth == other.productDepth && productHeight == other.productHeight
				&& Objects.equals(productName, other.productName) && productWidth == other.productWidth;
	}

	

	
	
	
	
	
}
