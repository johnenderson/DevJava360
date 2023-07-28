package com.issuetracker.engine.exception.handler;

import com.issuetracker.engine.dto.error.ErrorResponseDto;
import com.issuetracker.engine.exception.BadRequestException;
import com.issuetracker.engine.exception.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(NotFoundException.class)

    public ResponseEntity<ErrorResponseDto> notFoundException(NotFoundException n) {
        String errorMessage = n.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponseDto.builder()
                .message(n.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDto> badRequestException(BadRequestException b) {
        String errorMessage = b.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.builder()
                .message(b.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> badRequestException(MethodArgumentNotValidException m) {

        Map<String, String> messages = new HashMap<>();
        m.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            messages.put(field, defaultMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.builder()
                .message(Arrays.toString(messages.entrySet().toArray()))
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponseDto> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        String errorMessage = ex.getMessage();
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(ErrorResponseDto.builder()
                .message(errorMessage)
                .httpStatus(HttpStatus.METHOD_NOT_ALLOWED)
                .statusCode(HttpStatus.METHOD_NOT_ALLOWED.value())
                .build());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDto> badRequestException(DataIntegrityViolationException dive) {
        String errorMessage = dive.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.builder()
                .message(dive.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }

}