package tn.med.hexagonal.infrastructure.adaperts.output.customizedexception;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tn.med.hexagonal.domain.exception.ProductNotFound;
import tn.med.hexagonal.infrastructure.adaperts.output.customizedexception.data.response.ExceptionResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ControllerAdvice
@RestController
public class CustomizedExceptionAdapter  extends ResponseEntityExceptionHandler{
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), Arrays.asList(request.getDescription(false)));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFound.class)
    public final ResponseEntity<Object> handleUserNotFoundException(ProductNotFound ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), Arrays.asList(request.getDescription(false)));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        ex.getBindingResult().getAllErrors().stream().forEach(error -> {
            errors.add(error.getDefaultMessage());
        });

        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), "Validation Failed", errors);

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }



}