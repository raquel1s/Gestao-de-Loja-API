package com.weg.gestao_loja.dto.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProdutoRequisicaoDTO(
        @NotBlank(message = "O nome é obrigatório!")
        String nome,

        @NotBlank(message = "A descrição é obrigatória!")
        String descricao,

        @NotNull(message = "O preço é obrigatório!")
        @Positive
        BigDecimal preco,

        @NotNull(message = "A quantidade é obrigatória!")
        @PositiveOrZero
        int quantidade
) {

}
