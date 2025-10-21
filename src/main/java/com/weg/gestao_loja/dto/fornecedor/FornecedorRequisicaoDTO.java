package com.weg.gestao_loja.dto.fornecedor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record FornecedorRequisicaoDTO(
        @NotBlank(message = "O nome é obrigatório!")
        String nome,

        @NotBlank(message = "O cnpj é obrigatório!")
        @Max(value = 14, message = "CNPJ inválido!")
        String cnpj,

        @NotBlank(message = "O email é obrigatório!")
        @Email(message = "Email inválido!")
        String email,

        @NotBlank(message = "O telefone é obrigatório")
        String telefone
) {
}
