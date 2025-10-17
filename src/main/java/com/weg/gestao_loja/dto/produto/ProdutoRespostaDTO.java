package com.weg.gestao_loja.dto.produto;

public record ProdutoRespostaDTO(
        Long id,
        String nome,
        String descricao,
        double preco,
        int quantidade
) {

}
