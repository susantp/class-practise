package com.techbizz.westminster.classpractise.demo.productapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/***
 DispatcherServlet
 * <p>
 * Receives HTTP request and dispatches it
 * <p>
 * ↓
 * <p>
 * ProductController → ProductService
 * <p>
 * Service throws RuntimeException
 * <p>
 * ↓
 * <p>
 * DispatcherServlet receives the exception
 * <p>
 * Starts exception resolution
 * <p>
 * ↓
 * <p>
 * HandlerExceptionResolver
 * <p>
 * Uses ExceptionHandlerExceptionResolver to find a matching @ExceptionHandler
 * <p>
 * ↓
 * <p>
 * handleRuntimeException(ex)
 * <p>
 * Invokes your matching handler method
 * <p>
 * ↓
 * <p>
 * HTTP 400 Bad Request
 * <p>
 * Returns JSON ErrorResponse
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ProductNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }
}
