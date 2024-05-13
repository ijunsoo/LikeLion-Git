package com.homepage.likelion.controller.postcontroller;

import com.homepage.likelion.dto.PostDto.PostCreateDto;
import com.homepage.likelion.dto.PostDto.PostUpdateDto;
import com.homepage.likelion.service.PostService.PostService;
import com.homepage.likelion.utill.response.CustomApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @PostMapping
    public ResponseEntity<CustomApiResponse<?>> createPost(@Valid @RequestBody PostCreateDto.Req req) {
        ResponseEntity<CustomApiResponse<?>> result = postService.createPost(req);
        return result;
    }
    @PutMapping("/{postId}")
    public ResponseEntity<CustomApiResponse<?>> modifyPost(
            @PathVariable("postId") Long postId,
            @RequestBody PostUpdateDto.Req req) {
        ResponseEntity<CustomApiResponse<?>> result =postService.modifyPost(postId, req);
        return result;

    }
    @GetMapping
    public ResponseEntity<CustomApiResponse<?>> getOnePosts(@RequestParam("postId") Long postId) {
        ResponseEntity<CustomApiResponse<?>> result =postService.getOnePost(postId);
        return result;
    }
    @GetMapping("/all")
    public ResponseEntity<CustomApiResponse<?>> getAllPost() {
        ResponseEntity<CustomApiResponse<?>> result = postService.getAllPost();
        return result;
    }
}


