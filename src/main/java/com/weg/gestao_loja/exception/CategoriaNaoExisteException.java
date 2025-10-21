package com.weg.gestao_loja.exception;

public class CategoriaNaoExisteException extends RuntimeException{

    public CategoriaNaoExisteException() {
        super("Categoria não encontrada!");
    }
}
