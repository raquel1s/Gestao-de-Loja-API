package com.weg.gestao_loja.exception;

public class ProdutoNaoExisteException extends RuntimeException{

    public ProdutoNaoExisteException() {
        super("Produto não encontrado!");
    }
}
