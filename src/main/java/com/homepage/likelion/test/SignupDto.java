package com.homepage.likelion.test;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SignupDto {

    @NotEmpty(message = "email 은 필수값입니다.")
    @Email(message = "형식에 맞지않는 이메일입니다.")
    private String email;
    @NotEmpty(message = "userId 는 필수값입니다.")
    private String userId;
    @NotEmpty(message = "password 는 필수값입니다.")
    private String password;
}
