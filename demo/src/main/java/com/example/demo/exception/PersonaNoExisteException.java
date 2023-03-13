package com.example.demo.exception;

public class PersonaNoExisteException extends Exception{

    public PersonaNoExisteException(String nombre){
        super(String.format("El/La %s no existe",nombre));
    }
}
