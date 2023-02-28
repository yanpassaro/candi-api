package com.example.candi.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class Response<T> {
    private Integer statusCode;
    private HttpStatus status;
    private String message;
    private T data;
}