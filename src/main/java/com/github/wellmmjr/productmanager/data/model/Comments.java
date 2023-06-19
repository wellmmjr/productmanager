package com.github.wellmmjr.productmanager.data.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="product_comments") 
public class Comments implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="product_name", nullable = false, unique = true)
	private Long id;
	
	@Column(name="comment_text", nullable = false, length = 500)
	private String commentText;
	
	@Column(name="launch_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date launch_date;
	
	@Column(name="fkid_product")
	private Long productId;
	
	@Column(name="fkid_employee")
	private Long productEmployee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Date getLaunch_date() {
		return launch_date;
	}

	public void setLaunch_date(Date launch_date) {
		this.launch_date = launch_date;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductEmployee() {
		return productEmployee;
	}

	public void setProductEmployee(Long productEmployee) {
		this.productEmployee = productEmployee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commentText, id, launch_date, productEmployee, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comments other = (Comments) obj;
		return Objects.equals(commentText, other.commentText) && Objects.equals(id, other.id)
				&& Objects.equals(launch_date, other.launch_date)
				&& Objects.equals(productEmployee, other.productEmployee) && Objects.equals(productId, other.productId);
	}
	
	
}
