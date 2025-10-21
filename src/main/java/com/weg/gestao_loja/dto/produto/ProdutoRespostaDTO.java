package com.weg.gestao_loja.dto.produto;

import java.math.BigDecimal;

public record ProdutoRespostaDTO(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        int quantidade
) {

}
