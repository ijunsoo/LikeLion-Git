package com.homepage.likelion.test;

import com.homepage.likelion.utill.response.CustomApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserTestController {
    //Post http://localhost:8080/api/user/singup
    @PostMapping("/signup")
    public ResponseEntity<CustomApiResponse<?>> Signup(@Valid@RequestBody SignupDto dto) {

        //회원가입
        //System.out.println(dto.getUserId());
        System.out.println(dto.getEmail());


        //응답
        CustomApiResponse<Object> responseBody = CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "회원가입에 성공하였습니다.");
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);


    }
}
