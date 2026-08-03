package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="Follows",
	uniqueConstraints = @UniqueConstraint(
			columnNames = {"FOLLOWER_ID", "FOLLOWEE_ID"}
	)
)
public class Follow {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follow_seq")
    @SequenceGenerator(name = "follow_seq", sequenceName = "FOLLOW_SEQ", allocationSize = 1)
    Long Id;
	
	@Column(name = "CREATED_AT", nullable = false)
	   LocalDateTime createdAt;
	public Follow(AppUser follower, AppUser followee) {
		   super();
		   this.follower = follower;
		   this.followee = followee;
	   }
	   
    @PrePersist
    void onCreate() { this.createdAt = LocalDateTime.now(); }
    
    @ManyToOne(fetch = FetchType.LAZY) // 연관된 엔티티(앱유저) 당장 가져오는게 아니고
    @JoinColumn(name="FOLLOWER_ID", nullable = false)
    AppUser follower;
   
    @ManyToOne(fetch = FetchType.LAZY) // 실제 객체사용하는 시점에서 쿼리실행, 불필요한 조인 즐이기
    @JoinColumn(name="FOLLOWEE_ID", nullable = false)
    AppUser followee;
}
