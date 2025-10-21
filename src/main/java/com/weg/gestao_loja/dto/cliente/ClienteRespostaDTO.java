package com.weg.gestao_loja.dto.cliente;

public record ClienteRespostaDTO(
        String nome,
        String email,
        String telefone,
        String cpf
) {
}
