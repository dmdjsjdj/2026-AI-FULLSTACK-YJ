package com.thejoa703.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // ##
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.exception.ResourceNotFoundException;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.util.FileStorageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 데이터 저장(insert)시 rollback / readOnly=true 읽기전용
public class UserService {
	private final AppUserRepository appUserRepository; // ## @Autowired 대신
	private final FileStorageService fileStorageService;

	// 보안
	@Transactional
	public UserResponseDto createUser(UserRequestDto request, MultipartFile profileImage) {
		String provider = request.getProvider() != null ? request.getProvider() : "local";

		// 이메일 + provider 중복검사
		if (appUserRepository.findByEmailAndProvider(request.getEmail(), provider).isPresent()) {
			throw new IllegalArgumentException("이미 존재하는 사용자입니다");
		}
		// 닉네임 중복 검사
		if (appUserRepository.existsByNickname(request.getNickname())) {
			throw new IllegalArgumentException("이미 존재하는 사용자입니다");
		}
		AppUser user = new AppUser();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setNickname(request.getNickname());
		user.setProvider(provider);
		user.setRole("ROLE_USER");
		user.setUfile(profileImage != null && !profileImage.isEmpty() ? fileStorageService.upload(profileImage)
				: "uploads/thejoa703.png");

		return UserResponseDto.fromEntity(appUserRepository.save(user));
	}

	// 이메일중복검사
	public boolean existsByEmail(String email) {
		return appUserRepository.existsByEmail(email);
	}

	// 닉네임중복검사
	public boolean existsByNickname(String nickname) {
		return appUserRepository.existsByNickname(nickname);
	}

	// 로그인
	public UserResponseDto login(LoginRequest request) {
		// DB정보 : 이메일+provider로 사용자 조회, 없으면 예외
		AppUser user = appUserRepository
				.findByEmailAndProvider(request.getEmail(),
						request.getProvider() != null ? request.getProvider() : "local")
				.orElseThrow(() -> new ResourceNotFoundException("사용자 없음"));

		return UserResponseDto.fromEntity(user);
	}

	// 사용자 단건조회
	public UserResponseDto getUser(Long userId) {
		AppUser user = appUserRepository
				.findById(userId).orElseThrow(() -> new IllegalArgumentException("사용자 없음"));
		return UserResponseDto.fromEntity(user);
	}

	// 전체 사용자수
	public long countUsers() {
		return appUserRepository.count();
	}

	// Update : 닉네임 변경
	@Transactional
	public UserResponseDto updateNickname(Long userId, String newNickname) {
		// 닉네임 중복검사
		if (appUserRepository.existsByNickname(newNickname)) {
			throw new IllegalArgumentException("이미 사용중인 닉네임입니다.");
		}
		// 사용자조회 후
		AppUser user = appUserRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("사용자 없음"));
		
		System.out.println("before = " + user.getNickname());
		
		user.setNickname(newNickname); // ##2. 닉네임셋팅
		AppUser saved = appUserRepository.save(user);

	    System.out.println("after = " + saved.getNickname());

	    return UserResponseDto.fromEntity(saved);
	}

	// Update : 프로필 이미지변경
	@Transactional
	public UserResponseDto updateProfileImage(Long userId, MultipartFile profileImage) {
		// 사용자 조회
		AppUser user = appUserRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("사용자 없음"));
		
		System.out.println("===== BEFORE =====");
	    System.out.println(user.getNickname());
	    System.out.println(user.getUfile());
		
		// 새이미지 업로드 또는 기본 이미지 설정
		user.setUfile(profileImage != null && !profileImage.isEmpty() // 이미지가 빈게 아니라면
				? fileStorageService.upload(profileImage) // 업로드
				: "uploads/thejoa703.png"); // 기본값
		AppUser saved = appUserRepository.save(user);
		
		System.out.println("===== AFTER =====");
	    System.out.println(saved.getNickname());
	    System.out.println(saved.getUfile());
	    
		return UserResponseDto.fromEntity(saved); // 저장 후 dto반환
	}

	// 회원탈퇴
	@Transactional
	public void deleteById(Long userId) {
		//1. 소프트딜리트
		if(!appUserRepository.existsById(userId)) {
			throw new IllegalArgumentException("삭제할사용자 존재하지않음 id: " + userId);
		}
		
		appUserRepository.deleteById(userId);
	}
}
