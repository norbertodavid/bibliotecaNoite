package com.fuctura.bibliotecaNoite.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

//Essa é classe que é montada os parâmetros constando o que é mostrado nos erros.
public class StandardError {

    //@JsonFomato: passando como parâmetro o formato de como é mostrado a data e hora.
    @JsonFormat(pattern = "HH:mm - dd/MM/yyyy")
    private LocalDateTime timesTemp;
    private Integer status;
    private String message;
    private String path;

    public StandardError() {
    }

    public StandardError(LocalDateTime timesTemp, Integer status, String message, String path) {
        this.timesTemp = timesTemp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimesTemp() {
        return timesTemp;
    }

    public void setTimesTemp(LocalDateTime timesTemp) {
        this.timesTemp = timesTemp;
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
