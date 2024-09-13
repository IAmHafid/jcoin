package com.atlas.develop.jcoin.exception;

import com.atlas.develop.jcoin.entity.ErrorEntity;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ProjectExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectExceptionHandler.class);

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorEntity> badRequestHandler(BadRequestException exception) {
        ErrorEntity error = new ErrorEntity.Builder()
                .withTimeStamp(LocalDateTime.now())
                .withMessage(exception.getMessage())
                .withHttpStatus(HttpStatus.BAD_REQUEST.value())
                .build();

        LOGGER.error("{}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorEntity> runtimeExceptionHandler(RuntimeException exception) {
        ErrorEntity error = new ErrorEntity.Builder()
                .withTimeStamp(LocalDateTime.now())
                .withMessage(exception.getMessage())
                .withHttpStatus(HttpStatus.FORBIDDEN.value())
                .build();

        LOGGER.info("{}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(error);
    }
}
