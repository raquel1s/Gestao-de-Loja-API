package com.weg.gestao_loja.dto.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record ClienteRequisicaoDTO(
        @NotBlank(message = "O nome é obrigatório!")
        String nome,

        @NotBlank(message = "O email é obrigatório!")
        @Email(message = "Email inválido!")
        String email,

        @NotBlank(message = "O telefone é obrigatório!")
        String telefone,

        @NotBlank(message = "O CPF é obrigatório!")
        @Max(value = 14, message = "CPF inválido")
        String cpf
) {
}
