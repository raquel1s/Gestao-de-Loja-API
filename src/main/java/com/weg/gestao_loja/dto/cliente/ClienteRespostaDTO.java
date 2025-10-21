package com.weg.gestao_loja.dto.cliente;

public record ClienteRespostaDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf
) {
}
