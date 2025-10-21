package com.weg.gestao_loja.exception.cliente;

public class ClienteNaoExisteException extends RuntimeException{

    public ClienteNaoExisteException() {
        super("Cliente não encontrado!");
    }
}
