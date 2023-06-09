package com.user.service.UserService.Exceptions;

import com.user.service.UserService.Exceptions.ResourceNotFoundException;
import com.user.service.UserService.PayLoad.ApiResponse;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{
	
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
		String message = resourceNotFoundException.getMessage();
		ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
	return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
}
}