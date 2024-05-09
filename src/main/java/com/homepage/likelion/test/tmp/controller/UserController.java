package com.homepage.likelion.test.tmp.controller;

import com.homepage.likelion.test.users.dto.UserSignupDto;
import com.homepage.likelion.test.users.service.UserService;
import com.homepage.likelion.utill.response.CustomApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;
    @PostMapping("signup")
    public ResponseEntity<CustomApiResponse<?>> signup(@RequestBody UserSignupDto dto){
        return userService.signup(dto);

    }
}
