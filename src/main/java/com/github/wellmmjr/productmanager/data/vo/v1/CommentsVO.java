package com.github.wellmmjr.productmanager.data.vo.v1;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@JsonPropertyOrder({"id"})
public class CommentsVO extends RepresentationModel implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Mapping("id")
	@JsonProperty("id")
	private Long key;
	
	private String comment_text;
	
	private Date launch_date;
	
	private Long product_id;
	
	private Long product_employee;

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public Date getLaunch_date() {
		return launch_date;
	}

	public void setLaunch_date(Date launch_date) {
		this.launch_date = launch_date;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public Long getProduct_employee() {
		return product_employee;
	}

	public void setProduct_employee(Long product_employee) {
		this.product_employee = product_employee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(comment_text, key, launch_date, product_employee, product_id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentsVO other = (CommentsVO) obj;
		return Objects.equals(comment_text, other.comment_text) && Objects.equals(key, other.key)
				&& Objects.equals(launch_date, other.launch_date)
				&& Objects.equals(product_employee, other.product_employee)
				&& Objects.equals(product_id, other.product_id);
	}
	
	
}
