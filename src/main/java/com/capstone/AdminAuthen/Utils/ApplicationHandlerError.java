package com.capstone.AdminAuthen.Utils;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationHandlerError {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleValidArgument(MethodArgumentNotValidException ex, HttpServletResponse response){
        Map<String, Object> error = new HashMap<>();
        response.setStatus(400);
        error.put("code",response.getStatus());
        error.put("message","BAD_REQUEST");
        return error;
    }
}