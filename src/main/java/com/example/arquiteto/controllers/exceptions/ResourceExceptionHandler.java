package com.example.arquiteto.controllers.exceptions;

import com.example.arquiteto.services.exceptions.LivroIndisponivelException;
import com.example.arquiteto.services.exceptions.RegistroJaCadastradoException;
import com.example.arquiteto.services.exceptions.RegistroNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(RegistroJaCadastradoException.class)
    public ResponseEntity<StandardError> registroJaCadastrado(RegistroJaCadastradoException e){
        StandardError err = new StandardError(HttpStatus.CONFLICT.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    @ExceptionHandler(RegistroNaoEncontradoException.class)
    public ResponseEntity<StandardError> registroNaoEncontrado(RegistroNaoEncontradoException e){
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(LivroIndisponivelException.class)
    public ResponseEntity<StandardError> livroIndisponivel(LivroIndisponivelException e){
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
