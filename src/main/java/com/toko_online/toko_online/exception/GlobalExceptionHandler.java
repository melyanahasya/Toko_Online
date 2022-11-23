package com.toko_online.toko_online.exception;

import com.toko_online.toko_online.response.ResponeHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException notFoundException) {
        return ResponeHelper.error(notFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InternalErrorException.class)
    public ResponseEntity<?> internalEeror(InternalErrorException InternalErrorException) {
        return ResponeHelper.error(InternalErrorException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
