package com.travel.availabilityapiss.exception;

import com.travel.availabilityapiss.models.ErrorData;
import com.travel.availabilityapiss.models.ResponeMetaData;
import com.travel.availabilityapiss.models.SearchResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final String FAILED_STATUS = "Failed";
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<SearchResponse> handleContraintViolationException(ConstraintViolationException ex) {


        return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError(ex.getMessage())).setMetaData(ResponeMetaData.create().setStatus(FAILED_STATUS)),HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<SearchResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {


        return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError(String.valueOf("Required request parameter '"+ex.getParameterName()+"' not found !"))).setMetaData(ResponeMetaData.create().setStatus(FAILED_STATUS)),HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<SearchResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {


        return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError(String.valueOf(ex.getName()+" required type : "+ex.getRequiredType()))).setMetaData(ResponeMetaData.create().setStatus(FAILED_STATUS)),HttpStatus.BAD_REQUEST);
    }
}
