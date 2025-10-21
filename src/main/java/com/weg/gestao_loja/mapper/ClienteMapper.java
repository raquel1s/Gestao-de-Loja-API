package com.weg.gestao_loja.mapper;

import com.weg.gestao_loja.dto.cliente.ClienteRequisicaoDTO;
import com.weg.gestao_loja.dto.cliente.ClienteRespostaDTO;
import com.weg.gestao_loja.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente paraEntidade(ClienteRequisicaoDTO requisicaoDTO){
        return new Cliente(requisicaoDTO.nome(),
                requisicaoDTO.email(),
                requisicaoDTO.telefone(),
                requisicaoDTO.cpf());
    }

    public ClienteRespostaDTO paraRespostaDTO(Cliente cliente){
        return new ClienteRespostaDTO(cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getCpf());
    }

    public Cliente paraUpdate(Cliente cliente, ClienteRequisicaoDTO requisicaoDTO){
        if(!requisicaoDTO.nome().equals(cliente.getNome())){
            cliente.setNome(requisicaoDTO.nome());
        }

        if(!requisicaoDTO.email().equals(cliente.getEmail())){
            cliente.setEmail(requisicaoDTO.email());
        }

        if(!requisicaoDTO.telefone().equals(cliente.getTelefone())){
            cliente.setTelefone(requisicaoDTO.telefone());
        }

        if(!requisicaoDTO.cpf().equals(cliente.getCpf())){
            cliente.setCpf(requisicaoDTO.cpf());
        }

        return cliente;
    }

}
