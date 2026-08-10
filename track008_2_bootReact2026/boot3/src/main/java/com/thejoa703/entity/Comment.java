package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="COMMENTS")
@Getter @Setter
public class Comment {
	
	@Id // 기본키 primary 키 붙히기
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    @SequenceGenerator(name="comment_seq", sequenceName = "COMMENT_SEQ", allocationSize = 1)
    Long id;
	
	@Lob //대용량데이터처리 - CLOB(문자열), BLOB(이미지, 파일, 오디오, 영상...) : 들디 처리(Lob)
	@Column(nullable = false)
	String content;
	
	@Column
	private boolean deleted = false;   
	   
    @Column(name="CREATED_AT", nullable = false)
    private LocalDateTime createdAt;
   
    @Column(name="UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;
	
	@PrePersist
    void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
    }
   
    @PreUpdate
    void onUpdate() {
    	this.updatedAt = LocalDateTime.now();
    }
    
    @ManyToOne  
	@JoinColumn(name = "APP_USER_ID", nullable = false)   
	AppUser user;
    
    @ManyToOne  
	@JoinColumn(name = "POST_ID", nullable = false)   
	Post post;
}
