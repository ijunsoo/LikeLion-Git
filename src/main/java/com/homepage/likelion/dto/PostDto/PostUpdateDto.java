package com.homepage.likelion.dto.PostDto;

import lombok.*;

import java.time.LocalDateTime;

public class PostUpdateDto {
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Req {
        private Long postId;
        private String postedUserName;
        private String title;
        private String content;

    }
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UpdatePost {
        private LocalDateTime updatedAt;
        public UpdatePost(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }
    }

}
