package com.example.devsu.exception.cliente;

public class ClienteNotFoundException extends Exception{

    public ClienteNotFoundException(String message){
        super(message);
    }

    public ClienteNotFoundException(String message, Throwable err){
        super(message, err);
    }
}
