package com.fuctura.bibliotecaNoite.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

//Como é uma Classe Global, é usado a anotação @ControllerAdvice que marca essa classe como manipuladora
//de exceções global, que será aplicado a todos os controladores desta aplicação.
@ControllerAdvice
public class GlobalException {

    //Essa anotation pega o erro lançado pelo controlador e trata de acordo com o parâmetro passado.
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), e.getMessage(),
                request.getRequestURI().replace(request.getRequestURI(), "Não contem: " + request.getRequestURI() + " no Banco de Dados."));
        //vai retornar o status da ResponseEntity de objNotFouExc, e no corpo vai passar o erro tratado de acordo com o StandardError.
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
    }



}
