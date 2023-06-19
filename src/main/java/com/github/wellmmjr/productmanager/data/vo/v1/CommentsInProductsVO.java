package com.github.wellmmjr.productmanager.data.vo.v1;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.hateoas.RepresentationModel;

public class CommentsInProductsVO extends RepresentationModel implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String nome_produto;
	
	private ArrayList<CommentsVO> comments_product;

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public ArrayList<CommentsVO> getComments_product() {
		return comments_product;
	}

	public void setComments_product(ArrayList<CommentsVO> comments_product) {
		this.comments_product = comments_product;
	}
	
	
	
}
