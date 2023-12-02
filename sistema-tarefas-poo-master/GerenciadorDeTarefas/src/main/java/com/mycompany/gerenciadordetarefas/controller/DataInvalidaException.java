package com.mycompany.gerenciadordetarefas.controller;

public class DataInvalidaException extends Exception {
    public DataInvalidaException(String mensagem) {
        super(mensagem);
    }
}
