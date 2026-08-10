package com.thejoa703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	// @ManyToOne - postㅏ 1개여서 join을 쿼리를 만들어줌
	// findBy 조건1 AND 조건2
	// SELECT c FROM Comment c WHERE c.post.id = :postId AND c.deleted=false
	List<Comment> findByPostIdAndDeletedFalse(Long postId);
	
	// 삭제되지 않은 댓글 수 집계 
	
	long  countByPostIdAndDeletedFalse(Long postId);
}
/*
1. findBy 	조회		+ And
2. countBy 	갯수		+ OR
3. existsBy	존재여부	+ 엔티티안에 다른 엔티티 Post엔티티안에 Long id
4. deleteBy	
*/