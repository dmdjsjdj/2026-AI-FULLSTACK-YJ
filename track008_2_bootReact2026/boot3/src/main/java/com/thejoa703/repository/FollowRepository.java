package com.thejoa703.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.entity.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
	
		// 팔로우 단건 조회 = 팔로워 id와 팔로잉 id가 모두 일치하는 데이터가 있는지 확인
		Optional<Follow> findByFollower_IdAndFollowee_Id(Long followerId, Long followeeId);
		
		// 팔로잉 목록 조회 (내가 팔로우한 사람들 목록 -> follower 필드의 id로 찾기) * List<Follow>
		@EntityGraph(attributePaths = {"followee"})
		List<Follow> findByFollower_Id(Long followerId);
		
		// 팔로워 목록 조회 (나를 팔로우한 사람들 목록 -> following 필드의 id로 찾기) * List<Follow>
		@EntityGraph(attributePaths = {"follower"})
		List<Follow> findByFollowee_Id(Long followeeId);
		
		// 팔로잉 수 집계 (내가 팔로우한 사람 수 -> follower 필드의 id 수 세기) * long
		long countByFollower_Id(Long followerId);
		 
		// 팔로워 수 집계 (나를 팔로우한 사람 수 -> following 필드의 id 수 세기) * long
		long countByFollowee_Id(Long followeeId);

		// 언팔로우 (팔로우 취소) - DB에서 즉시 삭제하는 @Query 방식 적용
		@Modifying
		@Transactional
		@Query("DELETE FROM Follow f WHERE f.follower.id = :followerId AND f.followee.id = :followeeId")
		void deleteByFollower_IdAndFollowee_Id(@Param("followerId") Long followerId, @Param("followeeId") Long followeeId);
}
/*
create	- save		: insert
read	- findAll	: select * from 테이블명
		  findById	: select * from 테이블명 where id=?
update	- save		: update 테이블명 set 컬럼1=? ,,, where id=?
delete	- delete	: delete from 테이블명 where id=?
*/