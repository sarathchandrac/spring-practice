package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MobileNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleMobileNotFoundException(MobileNotFoundException mfe){
        ErrorDetails error = new ErrorDetails();
        error.setErrorCode(mfe.getErrorCode());
        error.setErrorMessage(mfe.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<ErrorDetails> handleThrowable(Throwable throwable){
        ErrorDetails error = new ErrorDetails();
        error.setErrorCode(1009);
        error.setErrorMessage(throwable.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }


}
