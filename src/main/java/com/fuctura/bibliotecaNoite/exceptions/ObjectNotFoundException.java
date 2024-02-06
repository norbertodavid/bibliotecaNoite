package com.fuctura.bibliotecaNoite.exceptions;

//classe que extende de RuntimeException e traz todos os parâmetros dela.
public class ObjectNotFoundException extends RuntimeException{

    //criei essa função que exibe a mensagem
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
