package kr.co.ares.exception.handler;

import kr.co.ares.exception.BadRequestException;
import kr.co.ares.exception.ResourceNotFoundException;
import kr.co.ares.exception.obj.ResponseEnvelop;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import kr.co.ares.exception.obj.Error;

import java.util.List;

@Log4j2
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) //400
    public ResponseEnvelop<Void> handleBadRequestException(BadRequestException e){

        Error error = new Error(e.getMessage());
        ResponseEnvelop<Void> returnEnvelop = new ResponseEnvelop<Void>(false, error);
        return returnEnvelop;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) //400
    public ResponseEnvelop<Void> handleNotfoundException(ResourceNotFoundException e){

        Error error = new Error(e.getMessage());
        ResponseEnvelop<Void> returnEnvelop = new ResponseEnvelop<Void>(false, error);
        return returnEnvelop;
    }

}
