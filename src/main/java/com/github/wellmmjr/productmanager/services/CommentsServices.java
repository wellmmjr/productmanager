package com.github.wellmmjr.productmanager.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.wellmmjr.productmanager.data.vo.v1.CommentsInProductsVO;
import com.github.wellmmjr.productmanager.data.vo.v1.CommentsVO;
import com.github.wellmmjr.productmanager.data.vo.v1.ProductVO;
import com.github.wellmmjr.productmanager.repository.CommentsRepository;

public class CommentsServices {

	@Autowired
	CommentsRepository repository;

	public CommentsVO create(CommentsVO commentVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public CommentsVO updateComment(CommentsVO commentVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteComments(Long id) {
		// TODO Auto-generated method stub
		
	}

	public ProductVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public CommentsInProductsVO commentsByIdProduct(Long id) {
		
	}

}
