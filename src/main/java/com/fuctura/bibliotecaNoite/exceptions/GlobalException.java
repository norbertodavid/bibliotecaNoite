package com.fuctura.bibliotecaNoite.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

//Anotação de ControllerAdvice
@ControllerAdvice
public class GlobalException {

    //Instanciamos a anotation: ExceptionHandler, passando como parâmetro a classe: ObjNotFounExcep
    @ExceptionHandler(ObjectNotFoundException.class)

    //função que recebe um ResponseEntity de StandardError e trás como função a classe objNotFound com os parâmetros: "e" de objNotFE e o "request" do HttpServlet
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());

        //retorna um resposeEntity.status com valor do status do HttpStatus de NOT_FOUND, e trazendo no body a variavel "se" de EstandardError
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
    }

    @ExceptionHandler(IllegalArgumentException.class)

    //função que recebe um ResponseEntity de StandardError e trás como função a classe IllegalArgu com os parâmetros: "e" de illegal e o "request" do HttpServlet
    public ResponseEntity<StandardError> illegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage(), request.getRequestURI());

        //retorna um resposeEntity.status com valor do status do HttpStatus de BAD_REQUEST, e trazendo no body a variavel "se" de EstandardError
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)

    //função que recebe um ResponseEntity de StandardError e trás como função a classe IllegalArgu com os parâmetros: "e" de illegal e o "request" do HttpServlet
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage(), request.getRequestURI());

        //retorna um resposeEntity.status com valor do status do HttpStatus de BAD_REQUEST, e trazendo no body a variavel "se" de EstandardError
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }

}
