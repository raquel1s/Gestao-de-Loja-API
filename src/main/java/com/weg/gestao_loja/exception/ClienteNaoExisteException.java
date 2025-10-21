package com.weg.gestao_loja.exception;

public class ClienteNaoExisteException extends RuntimeException{

    public ClienteNaoExisteException() {
        super("Cliente não encontrado!");
    }
}
