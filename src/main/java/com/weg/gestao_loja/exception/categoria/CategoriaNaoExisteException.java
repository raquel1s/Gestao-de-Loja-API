package com.weg.gestao_loja.exception.categoria;

public class CategoriaNaoExisteException extends RuntimeException{

    public CategoriaNaoExisteException() {
        super("Categoria não encontrada!");
    }
}
