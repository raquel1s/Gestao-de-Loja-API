package com.weg.gestao_loja.mapper;

import com.weg.gestao_loja.dto.fornecedor.FornecedorRequisicaoDTO;
import com.weg.gestao_loja.dto.fornecedor.FornecedorRespostaDTO;
import com.weg.gestao_loja.model.Fornecedor;
import org.springframework.stereotype.Component;

@Component
public class FornecedorMapper {

    public Fornecedor paraEntidade(FornecedorRequisicaoDTO requisicaoDTO){
        return new Fornecedor(requisicaoDTO.nome(),
                requisicaoDTO.cnpj(),
                requisicaoDTO.email(),
                requisicaoDTO.telefone());
    }

    public FornecedorRespostaDTO paraRespostaDTO(Fornecedor cliente){
        return new FornecedorRespostaDTO(cliente.getId(),
                cliente.getNome(),
                cliente.getCnpj(),
                cliente.getEmail(),
                cliente.getTelefone());
    }

    public Fornecedor paraUpdate(Fornecedor fornecedor, FornecedorRequisicaoDTO requisicaoDTO){
        if(!requisicaoDTO.nome().equals(fornecedor.getNome())){
            fornecedor.setNome(requisicaoDTO.nome());
        }

        if(!requisicaoDTO.email().equals(fornecedor.getEmail())){
            fornecedor.setEmail(requisicaoDTO.email());
        }

        if(!requisicaoDTO.telefone().equals(fornecedor.getTelefone())){
            fornecedor.setTelefone(requisicaoDTO.telefone());
        }

        if(!requisicaoDTO.cnpj().equals(fornecedor.getCnpj())){
            fornecedor.setCnpj(requisicaoDTO.cnpj());
        }

        return fornecedor;
    }
}
