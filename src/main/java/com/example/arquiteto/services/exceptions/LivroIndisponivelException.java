package com.example.arquiteto.services.exceptions;

public class LivroIndisponivelException extends RuntimeException {

    public LivroIndisponivelException(String msg) {
        super(msg);
    }

    public LivroIndisponivelException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
