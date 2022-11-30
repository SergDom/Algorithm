package com.nomad.algorithm.exceptions;

public class EmptyArgumentException extends RuntimeException {
    public EmptyArgumentException(String message) {
        super(message);
    }
}