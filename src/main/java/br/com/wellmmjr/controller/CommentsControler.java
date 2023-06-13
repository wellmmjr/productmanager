package br.com.wellmmjr.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wellmmjr.data.vo.v1.CommentsVO;
import br.com.wellmmjr.data.vo.v1.ProductVO;
import br.com.wellmmjr.services.CommentsServices;
import br.com.wellmmjr.services.ProductServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Comments Endpoints", description = "Accepts and provides entity Comments xml, x-yaml, json contents", 
tags= {"Comments Endpoints", "Comments"})
@RestController
@RequestMapping("/api/comments/v1")
public class CommentsControler {

	@Autowired
	private CommentsServices services;
	
	@Autowired
	private PagedResourcesAssembler<CommentsVO> assemble;
	
	@ApiOperation(value="Allows create Commentse by this endpoint")
	@PostMapping(value = "/create", produces = {"application/json", "application/xml", "application/x-yaml"}, 
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public CommentsVO create(@RequestBody CommentsVO commentVO){
		
		commentsVO commentsVO = services.create(commentVO);
		commentsVO.add(linkTo(methodOn(CommentsControler.class).findById(commentVO.getKey())).withSelfRel());
		return commentsVO;
		
	}
	
	@ApiOperation(value="Allows update Product by id through endpoint")
	@PutMapping(value = "/update", produces = {"application/json", "application/xml", "application/x-yaml"}, 
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public CommentVO update(@RequestBody CommentVO commentVO){
		
		CommentVO commentVO = services.updateComment(product);
		commentVO.add(linkTo(methodOn(CommentsControler.class).findById(commentVO.getKey())).withSelfRel());
		return commentVO;
		
	}
	
	@ApiOperation(value="Delete Comments info by its id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id" ) Long id){
		
		services.deleteComments(id);
		return ResponseEntity.ok().build();
		
	}
	
	
	@ApiOperation(value="Loads Person's info by its id")
	@GetMapping(value="/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public ProductVO findById(@PathVariable("id" ) Long id){
		
		ProductVO personVO = services.findById(id);
		personVO.add(linkTo(methodOn(ProductController.class).findById(id)).withSelfRel());
		return personVO;
		
	}
}
