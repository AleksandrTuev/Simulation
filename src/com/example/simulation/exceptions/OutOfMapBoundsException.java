package com.example.simulation.exceptions;

public class OutOfMapBoundsException extends IllegalArgumentException{
    public OutOfMapBoundsException(String message) {
        super(message);
    }
}
