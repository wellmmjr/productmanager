package com.github.wellmmjr.productmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.github.wellmmjr.productmanager.converter.DozerConverter;
import com.github.wellmmjr.productmanager.data.model.Comments;
import com.github.wellmmjr.productmanager.data.model.Product;
import com.github.wellmmjr.productmanager.data.vo.v1.CommentsVO;
import com.github.wellmmjr.productmanager.data.vo.v1.ProductVO;
import com.github.wellmmjr.productmanager.exception.ResourceNotFoundException;
import com.github.wellmmjr.productmanager.repository.CommentsRepository;

public class CommentsServices {

	@Autowired
	CommentsRepository repository;
	
	@Autowired
	ProductServices productRepository;

	public CommentsVO create(CommentsVO commentVO, Long productId) {
		Product entity = productRepository.findById(productId).
				orElseThrow(() -> new ResourceNotFoundException("no records found for this product")) ;
		
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
	
	public Page<CommentsVO> commentsByIdProduct(Long id, Pageable pageable) {
		var page = repository.findCommentsByProduct(id, pageable);
		return page.map(this::convertCommentsVO);
	}
	
	private CommentsVO convertCommentsVO(Comments entity) {
		return DozerConverter.parseObject(entity, CommentsVO.class);
	}

}
