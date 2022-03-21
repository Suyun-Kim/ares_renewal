package kr.co.ares.exception.handler;

import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestControllerAdvice
public class CustomExceptionHandler {

    @Data
    private static class ErrorResponse {

        private int errCode;
        private String errorMessage;
        private List<FieldError> fieldErrors;

        ErrorResponse(int errCode, String errorMessage) {
            this.errCode = errCode;
            this.errorMessage = errorMessage;
        }

        public void addFieldError(String path, String message) {
            FieldError error = new FieldError(path, message, "test");
            fieldErrors.add(error);
        }

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse BadRequestException (MethodArgumentNotValidException  ex) {
        log.warn("error", ex);
        BindingResult br = ex.getBindingResult();
        List<FieldError> fieldErrors = br.getFieldErrors();

        return processFieldErrors(fieldErrors);

    }

    private ErrorResponse processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "validation error");
        for (FieldError fieldError: fieldErrors) {
            error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return error;
    }



}
