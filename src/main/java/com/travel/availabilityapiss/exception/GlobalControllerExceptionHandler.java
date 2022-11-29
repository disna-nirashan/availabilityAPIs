package com.travel.availabilityapiss.exception;

import com.travel.availabilityapiss.models.ErrorData;
import com.travel.availabilityapiss.models.ResponeMetaData;
import com.travel.availabilityapiss.models.SearchResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<SearchResponse> handleContraintViolationException(ConstraintViolationException ex) {

        System.out.println(ex);
        return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError(ex.getMessage())).setMetaData(ResponeMetaData.create().setStatus("Faild")),HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<SearchResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {

        System.out.println(ex);
        return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError(ex.getMessage())).setMetaData(ResponeMetaData.create().setStatus("Faild")),HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<SearchResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {

        System.out.println(ex);
        return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError(ex.getMessage())).setMetaData(ResponeMetaData.create().setStatus("Faild")),HttpStatus.BAD_REQUEST);
    }
}
