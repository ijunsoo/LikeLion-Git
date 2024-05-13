package com.homepage.likelion.domain.posts;

import com.homepage.likelion.utill.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="POSTS")
@Builder
public class Post extends BaseEntity {

    @Id@GeneratedValue
    @Column(name = "POSTS_ID")
    private Long id;
    @Column(name = "POSTS_TITLE")
    private String title;
    @Column(name="POSTED_CONTENT")
    private String content;
    @Column(name="POSTS_PASSWORD")
    private String postedUserName;

    private String password;
    public void changeTitle(String title) {
        this.title = title;
    }
    public void changeContent(String content) {
        this.content = content;
    }
    public void changeUserName(String postedUserName) {
        this.postedUserName = postedUserName;
    }
}
