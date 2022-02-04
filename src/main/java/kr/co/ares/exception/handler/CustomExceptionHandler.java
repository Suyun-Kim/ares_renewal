package kr.co.ares.exception.handler;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @Data
    @Builder
    private static class ErrorResponse {

        private int errCode;
        private String errorMessage;

    }

    @ExceptionHandler
    @ResponseBody
    public ErrorResponse errorHandler(Exception e) {

        return null;

    }

}
