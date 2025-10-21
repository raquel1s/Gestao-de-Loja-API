package com.weg.gestao_loja.exception.fornecedor;

public class FornecedorNaoExisteException extends RuntimeException{

    public FornecedorNaoExisteException() {
        super("Fornecedor não encontrado!");
    }
}
