package com.homepage.likelion.service.PostService;

import com.homepage.likelion.domain.posts.Post;
import com.homepage.likelion.dto.PostDto.PostCreateDto;
import com.homepage.likelion.dto.PostDto.PostListDto;
import com.homepage.likelion.dto.PostDto.PostUpdateDto;
import com.homepage.likelion.domain.posts.PostRepository;
import com.homepage.likelion.utill.response.CustomApiResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Builder
public class PostServicempl implements PostService {

    private final PostRepository postRepository;

    @Override
    public ResponseEntity<CustomApiResponse<?>> createPost(PostCreateDto.Req req) {
// 방법 1. toEntity() 메서드를 호출하여 엔티티 객체를 생성
        Post post = req.toEntity();
        // 방법 2. builder
// Post post = Post.builder()
// .title(req.getTitle())
// .content(req.getContent())
// .password(req.getPassword())
// .postedUserName(req.getPostedUserName())
// .build();
        Post savedPost = postRepository.save(post);
// 생성된 게시글의 정보를 포함한 응답 반환
        PostCreateDto.CreatePost createdPostResponse = new PostCreateDto.CreatePost(savedPost.getId(),savedPost.getUpdatedAt());
        CustomApiResponse<PostCreateDto.CreatePost> res = CustomApiResponse.createSuccess(HttpStatus.OK.value(), createdPostResponse,"게시글이 작성되었습니다");
        return ResponseEntity.ok(res);

    }
    @Override
    public ResponseEntity<CustomApiResponse<?>> modifyPost(Long postId, PostUpdateDto.Req req) {
        Optional<Post> optionalpost = postRepository.findById(postId);

        //게시물 업데이트
        Post post =optionalpost.get();
        post.changeTitle(req.getTitle());
        post.changeContent(req.getContent());
        post.changeUserName(req.getPostedUserName());
        postRepository.flush();

        //수정된 게시글 정보 응답
        PostUpdateDto.UpdatePost data =new PostUpdateDto.UpdatePost(post.getUpdatedAt());
        CustomApiResponse<PostUpdateDto.UpdatePost> res =CustomApiResponse.createSuccess(HttpStatus.OK.value(), data, "게시글이 수정되었습니다.");
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @Override
    public ResponseEntity<CustomApiResponse<?>> getOnePost(Long postId) {
        Optional<Post> optionalpost = postRepository.findById(postId);
        if (optionalpost.isEmpty()) {
            CustomApiResponse<Void> res =CustomApiResponse.createFailWithoutData(HttpStatus.NOT_FOUND.value(),
              "해당 게시글을 찾을수없습니다");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }
        Post post = optionalpost.get();
        PostListDto.PostResponse postResponse =new PostListDto.PostResponse(
                post.getId(),
                post.getPostedUserName(),
                post.getTitle(),
                post.getContent(),
                post.getUpdatedAt()
        );
        CustomApiResponse<PostListDto.PostResponse> res =CustomApiResponse.createSuccess(HttpStatus.OK.value(), postResponse,"해당 게시글 조회 성공");
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    @Override
    public ResponseEntity<CustomApiResponse<?>> getAllPost(){
        List<Post> posts = postRepository.findAll();
        List<PostListDto.PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            postResponses.add(PostListDto.PostResponse.builder()
                    .postId(post.getId())
                    .postedUserName(post.getPostedUserName())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .updatedAt(post.getUpdatedAt())
                    .build());
        }
        PostListDto.SearchPostsRes searchPostsRes = new PostListDto.SearchPostsRes(postResponses);
        CustomApiResponse<PostListDto.SearchPostsRes> res = CustomApiResponse.createSuccess(HttpStatus.OK.value(), searchPostsRes, "전체 게시글 조회 성공");
        return ResponseEntity.status(HttpStatus.OK).body(res);



    }
}
