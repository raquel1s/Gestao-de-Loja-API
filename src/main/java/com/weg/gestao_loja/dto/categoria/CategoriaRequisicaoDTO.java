package com.weg.gestao_loja.dto.categoria;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequisicaoDTO(
        @NotBlank(message = "O nome é obrigatório!")
        String nome,

        @NotBlank(message = "A descrição é obrigatória!")
        String descricao
) {

}
