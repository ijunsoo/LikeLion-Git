package com.homepage.likelion.test;

import com.homepage.likelion.utill.response.CustomApiResponse;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Builder
@RestController
@RequestMapping("/api/customResponse")
public class CustomTestController {
    @PostMapping("/simple")
    public ResponseEntity<CustomApiResponse<?>> simple() {
        CustomApiResponse<Object> responseBody = CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "회원가입에 성공하였습니다");
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @GetMapping("/jsonData")
    public ResponseEntity<CustomApiResponse<?>> jsonData() {
        //SimpleDto dto = new SimpleDto("example", "example@naver.com");
        SimpleDto dto = SimpleDto.builder()
                .userid("example")
                .email("example@naver.com")
                .build();

        CustomApiResponse<Object> responseBody = CustomApiResponse.createSuccess(HttpStatus.OK.value(), dto, "회원 조회에 성공하였습니다");
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}