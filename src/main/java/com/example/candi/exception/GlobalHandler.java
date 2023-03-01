package com.example.candi.exception;

import com.example.candi.domain.Response;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
@Order(HIGHEST_PRECEDENCE)
public class GlobalHandler {
    @ExceptionHandler(value = InvalidTokenException.class)
    public ResponseEntity<Response> handleIncorrectCredentialsException(InvalidTokenException ex) {
        return ResponseEntity.badRequest().body(
                Response.builder()
                        .message(ex.getMessage())
                        .statusCode(BAD_REQUEST.value())
                        .status(BAD_REQUEST)
                        .build()
        );
    }

    @ExceptionHandler(value = JobNotExistException.class)
    public ResponseEntity<Response> handleJobNotExistException(JobNotExistException ex) {
        return ResponseEntity.badRequest().body(
                Response.builder()
                        .message(ex.getMessage())
                        .statusCode(BAD_REQUEST.value())
                        .status(BAD_REQUEST)
                        .build()
        );
    }
}
