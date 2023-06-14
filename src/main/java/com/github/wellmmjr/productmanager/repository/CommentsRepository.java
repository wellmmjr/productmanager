package com.github.wellmmjr.productmanager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.wellmmjr.productmanager.data.model.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Long>{

	
	@Query("SELECT c FROM product_comments c "
			+ "left join product p on c.fkid_porduct = p.id "
			+ "WHERE c.fkid_product = :productId AND p.enable = true ORDER BY launch_date desc ")
	Page<Comments> findCommentsByProduct(@Param("productId") int productId, Pageable pageable);
	
}
