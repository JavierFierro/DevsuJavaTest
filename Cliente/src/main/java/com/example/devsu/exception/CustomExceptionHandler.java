package com.example.devsu.exception;

import com.example.devsu.exception.cliente.ClienteNotFoundException;
import com.example.devsu.exception.cliente.InvalidBodyPropertiesException;
import com.example.devsu.exception.cuenta.CuentaNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<String> handleClienteNotFoundException(ClienteNotFoundException ex) {
        logger.info("ClienteNotFoundException caught");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);

    }

    @ResponseBody
    @ExceptionHandler(InvalidBodyPropertiesException.class)
    public ResponseEntity<String> handleInvalidBodyPropertiesException(InvalidBodyPropertiesException ex) {
        logger.info("InvalidBodyPropertiesException caught");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);

    }

    @ResponseBody
    @ExceptionHandler(CuentaNotFoundException.class)
    public ResponseEntity<String> handleCuentaNotFoundException(CuentaNotFoundException ex) {
        logger.info("CuentaNotFoundException caught");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);

    }

}
