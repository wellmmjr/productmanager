package com.github.wellmmjr.productmanager.data.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="product_comments") 
public class Comments implements Serializable {

	private static final long serialVersionUID = 1L;

}
