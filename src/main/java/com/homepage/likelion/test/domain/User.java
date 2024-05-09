package com.homepage.likelion.test.domain;

import com.homepage.likelion.utill.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="user_id")
    private String userId;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

}
