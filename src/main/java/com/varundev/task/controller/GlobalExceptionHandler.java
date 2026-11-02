package com.varundev.task.controller;

import com.varundev.task.domain.dto.ErrorDto;
import com.varundev.task.exception.TaskNotFoundException;
import org.jspecify.annotations.Nullable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;
import java.util.UUID;

// Handles the exceptions and returns the appropriate errors to our API callers
@ControllerAdvice
public class GlobalExceptionHandler {

    // tells which exception this method wants to handle
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("Validation failed.");

        return new ResponseEntity<>(new ErrorDto(errorMessage), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorDto> handlesNotFoundException(TaskNotFoundException ex) {
        UUID taskNotFoundId = ex.getId();
        String errorMessage = String.format("Task with id %s not found", taskNotFoundId);
        // we don't want to expose the whole exception message to the caller, therefore custom exceptions with
        // minimal data
        ErrorDto errorDto = new ErrorDto(errorMessage);
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
