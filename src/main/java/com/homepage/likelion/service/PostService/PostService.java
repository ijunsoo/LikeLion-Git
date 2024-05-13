package com.homepage.likelion.service.PostService;

import com.homepage.likelion.dto.PostDto.PostCreateDto;
import com.homepage.likelion.dto.PostDto.PostUpdateDto;
import com.homepage.likelion.utill.response.CustomApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    ResponseEntity<CustomApiResponse<?>> createPost(PostCreateDto.@Valid Req req);

    ResponseEntity<CustomApiResponse<?>> modifyPost(Long postId, PostUpdateDto.Req req);

    ResponseEntity<CustomApiResponse<?>> getOnePost(Long postId);

    ResponseEntity<CustomApiResponse<?>> getAllPost();
}
