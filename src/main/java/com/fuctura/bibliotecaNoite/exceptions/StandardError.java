package com.fuctura.bibliotecaNoite.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

//Esta classe é criada para moldar a forma como a mensagem de erro retorna.
public class StandardError {
    //O formato Jason, passando o pattern: hora, min, dia, mes e ano em que o erro acontece.
    @JsonFormat(pattern = "HH:mm - dd/MM/yyyy")
    private LocalDateTime timestemp;
    private Integer status;
    private String message;
    private String path;


    public StandardError() {
        //Construtor vazio, criado como boas práticas
    }

    //Construtor com parâmetros
    public StandardError(LocalDateTime timestemp, Integer status, String message, String path) {
        this.timestemp = timestemp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    //Getters e Setters
    public LocalDateTime getTimestemp() {
        return timestemp;
    }

    public void setTimestemp(LocalDateTime timestemp) {
        this.timestemp = timestemp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
