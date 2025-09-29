package org.arcsoft.controller;

import jakarta.validation.ValidationException;
import org.arcsoft.dto.error.ErrorResponse;
import org.arcsoft.exception.NotEnoughMoneyException;
import org.arcsoft.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, ValidationException.class, NotEnoughMoneyException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(Exception e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e) {
        return new ErrorResponse(e.getMessage());
    }
}
