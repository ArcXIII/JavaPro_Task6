package org.arcsoft.controller;

import org.arcsoft.dto.error.ErrorResponse;
import org.arcsoft.exception.ProductNotFoundException;
import org.arcsoft.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class, ProductNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(Exception e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleDefaultException(Exception e) {
        return new ErrorResponse(e.getMessage());
    }
}
