package com.weg.gestao_loja.dto.fornecedor;

public record FornecedorRespostaDTO(
        Long id,
        String nome,
        String cnpj,
        String email,
        String telefone
) {
}
