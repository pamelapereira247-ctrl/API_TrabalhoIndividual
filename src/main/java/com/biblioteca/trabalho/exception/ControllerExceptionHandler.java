package com.biblioteca.trabalho.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException; 
import org.springframework.web.bind.annotation.ControllerAdvice; 
import org.springframework.web.bind.annotation.ExceptionHandler; 
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice 
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResposta> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        
        List<String> erros = ex.getBindingResult().getAllErrors().stream()
                .map(error -> {
                    String fieldName = (error instanceof FieldError) ? ((FieldError) error).getField() : "Objeto";
                    return fieldName + ": " + error.getDefaultMessage();
                })
                .collect(Collectors.toList());

        ErroResposta erroResposta = new ErroResposta(
                new Date(),
                HttpStatus.BAD_REQUEST.value(), 
                "Dados Inválidos",
                "Ocorreu uma falha ao processar os dados enviados. Consulte a lista de 'detalhes' abaixo.",
                erros
        );

        return new ResponseEntity<>(erroResposta, HttpStatus.BAD_REQUEST);
    }
}