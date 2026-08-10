package com.thejoa703.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.PostDto.PostRequestDto;
import com.thejoa703.dto.PostDto.PostResponseDto;
import com.thejoa703.entity.Post;
import com.thejoa703.service.AuthUserJwtService;
import com.thejoa703.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name="Post Api", description="게시글 작성 관련 API")  // swagger
@RestController    // @Controller + @ResponseBody 
@RequestMapping("/api/posts")
@RequiredArgsConstructor
//@CrossOrigin(origins="*")
public class PostController {
	private final PostService postService;
	private final AuthUserJwtService authUserJwtService; //### 

	//- POST      /api/posts      게시글 작성
	@Operation(summary = "게시글 작성", description = "특정유저의 ID와 내용을 받아 게시글을 작성합니다.")
	@PostMapping( consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<PostResponseDto> createPost(
			Authentication authentication,
			//@Parameter(description = "작성자 사용자 ID")  @RequestParam("userId") Long userId,
			@ModelAttribute PostRequestDto dto,      // multipart/form-data
            @Parameter(description = "프로필 이미지 파일")   // swagger
            @RequestPart(name="files", required=false) List<MultipartFile> files) 
	{
		Long userId = authUserJwtService.getCurrentUserId(authentication);
		return ResponseEntity.ok(postService.createPost(userId, dto, files));  // HttpStatus.CREATED 201
	}
	
	//- GET      /api/posts      전체 게시글 조회
//	@Operation(summary = "게시글 조회", description = "등록된 모든 게시글 목록을 조회합니다.")
//	@GetMapping
//	public ResponseEntity<List<PostResponseDto>> getPost() {
//		List<Post> posts = postService.getAllPosts();
//		
//		List<PostResponseDto> lists = posts.stream()
//				.map(PostResponseDto::new) // 또는 PostResponseDto::new
//				.collect(Collectors.toList());
//				
//		return ResponseEntity.ok(lists);  // 200
//	}
	
	@Operation(summary = "전체 게시", description = "전체 게시글")
	@GetMapping
	public ResponseEntity<List<PostResponseDto>> getPost() {
				
		return ResponseEntity.ok(postService.getAllPosts());  // 200
	}
	
	//- GET        /api/posts/{id}      게시글 단건 조회 ※  getPostById 
	@Operation(summary = "단건 조회", description = "특정 게시글을 조회합니다.")
	@GetMapping("/{id}")
	public ResponseEntity<PostResponseDto> getPostById(@PathVariable("id") Long id) {
		Post post = postService.getPostById(id);
				
		return ResponseEntity.ok(new PostResponseDto(post));  // 200
	}
	
//	//- Patch        /api/posts/{postid}      게시글 수정     ※  updatePost
//	@Operation(summary = "게시글 수정", description = "특정유저의 ID를 받아와 게시글을 수정합니다.")
//	@PatchMapping("/{postid}")
//	public ResponseEntity<PostResponseDto> updatePost(
//							@PathVariable("id") Long id,
//							@RequestBody PostRequestDto requestDto) {
//		Post updatePost = postService.updatePost(id, requestDto.getContent());
//		return ResponseEntity.ok(new PostResponseDto(updatePost));  // HttpStatus.CREATED 201
//	}

	@Operation(summary = "게시글 수정", description = "특정유저의 ID를 받아와 게시글을 수정합니다.")
	@PatchMapping(value="/{postId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<PostResponseDto> updatePost( 
			Authentication authentication,
			//@Parameter(description = "작성자 사용자 ID")  @RequestParam("userId") Long userId,
			@Parameter(description = "수정할 게시글 ID")  @PathVariable(name="postId") Long postId,
			@ModelAttribute PostRequestDto dto,
			@Parameter(description = "수정시 업로드할 이미지 파일 리스트")   // swagger
            @RequestPart(name="files", required=false) List<MultipartFile> files
	) {
		Long userId = authUserJwtService.getCurrentUserId(authentication);
		return ResponseEntity.ok(postService.updatePost(userId,postId, dto, files));  // HttpStatus.CREATED 201
	}

	//- DELETE   /api/posts/{id}      게시글 삭제     ※  deletePost
	@Operation(summary = "게시글 삭제", description = "특정유저의 ID를 받아와 게시글을 삭제합니다.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deletePost(
			Authentication authentication, @PathVariable("id") Long id) {
		Long userId = authUserJwtService.getCurrentUserId(authentication);
		postService.deletePost(userId, id);
		return ResponseEntity.ok(id);  // HttpStatus.CREATED 201
	}
}

//2. Post API     - 게시글 관련 API
//- GET        /api/posts/{id}      게시글 단건 조회 ※  getPostById 
//- PUT        /api/posts/{id}      게시글 수정     ※  updatePost
//- DELETE   /api/posts/{id}      게시글 삭제     ※  deletePost
//- GET        /api/posts      전체 게시글 조회     ※  getAllPosts , getPostPaged
//- POST      /api/posts      게시글 작성         ※  postService.createPost 