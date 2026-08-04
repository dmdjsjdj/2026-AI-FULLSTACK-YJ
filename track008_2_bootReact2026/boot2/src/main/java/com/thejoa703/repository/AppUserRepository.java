package com.thejoa703.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.AppUser;

@Repository											  // Entity , PK-자료형
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	Optional<AppUser> findByEmail(String email);
	
	// 단건조회
	Optional<AppUser> findByEmailAndProvider(String email, String provider);
	
	// 닉네임으로 조회
	Optional<AppUser> findByNickname(String nickname);
	
	// 닉네임 중복
	boolean existsByNickname(String nickname);
	
	// 이메일 중복
	boolean existsByEmail(String email);
}

// create - save 		: insert into app_user (컬럼,,,) values (?,?,?,,,)
// read   - findAll  	: select * from app_user 
//			findById 	: select * from app_user where id=?
// update - save     	: update  테이블명  set  컬럼1=? where id=?
// delete - deleteById 	: delete from 테이블명 where id=?

/*
1. 검색 : findBy필드명
*/