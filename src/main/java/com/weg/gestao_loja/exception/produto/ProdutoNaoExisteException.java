package com.weg.gestao_loja.exception.produto;

public class ProdutoNaoExisteException extends RuntimeException{

    public ProdutoNaoExisteException() {
        super("Produto não encontrado!");
    }
}
