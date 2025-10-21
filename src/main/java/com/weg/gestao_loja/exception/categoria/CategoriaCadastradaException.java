package com.weg.gestao_loja.exception.categoria;

public class CategoriaCadastradaException extends RuntimeException{

    public CategoriaCadastradaException() {
        super("Categoria já está cadastrada!");
    }
}
