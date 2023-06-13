package br.com.wellmmjr.data.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="product_comments") 
public class Comments implements Serializable {

	private static final long serialVersionUID = 1L;

}
