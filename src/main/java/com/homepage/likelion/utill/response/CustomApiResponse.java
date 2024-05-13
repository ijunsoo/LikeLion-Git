package com.homepage.likelion.utill.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomApiResponse<T> {
    private int status;
    private T data;

    private String message;

    public static <T> CustomApiResponse<T> createSuccess(int status, T data, String message){
        return new CustomApiResponse<>(status, data, message);
    }
    public static <T> CustomApiResponse<T> createFailWithout(int status,String message){
        return new CustomApiResponse<>(status, null,message);
    }

    public static <T> CustomApiResponse<T> createFailWithoutData(int value, String message) {
        return new CustomApiResponse<>(value, null,message);
    }
}
