package com.weg.gestao_loja.service;

import com.weg.gestao_loja.dto.cliente.ClienteRequisicaoDTO;
import com.weg.gestao_loja.dto.cliente.ClienteRespostaDTO;
import com.weg.gestao_loja.exception.ClienteCadastradoException;
import com.weg.gestao_loja.exception.ClienteNaoExisteException;
import com.weg.gestao_loja.mapper.ClienteMapper;
import com.weg.gestao_loja.model.Cliente;
import com.weg.gestao_loja.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteRespostaDTO criar(ClienteRequisicaoDTO requisicaoDTO){
        if(repository.existsByEmail(requisicaoDTO.email())){
            throw new ClienteCadastradoException("Email já cadastrado!");
        }

        if(repository.existsByCpf(requisicaoDTO.cpf())){
            throw new ClienteCadastradoException("CPF já cadastrado!");
        }

        return mapper.paraRespostaDTO(repository.save(mapper.paraEntidade(requisicaoDTO)));
    }

    public List<ClienteRespostaDTO> buscarTodos(){
        return repository.findAll().stream().map(mapper::paraRespostaDTO).toList();
    }

    public ClienteRespostaDTO buscarPorId(Long id){
        return mapper.paraRespostaDTO(repository.findById(id).orElseThrow(() -> {
            throw new ClienteNaoExisteException();
        }));
    }

    public ClienteRespostaDTO atualizar(Long id, ClienteRequisicaoDTO requisicaoDTO){
        Cliente cliente = repository.findById(id).orElseThrow(() -> {
            throw new ClienteNaoExisteException();
        });

        Cliente newCliente = mapper.paraUpdate(cliente, requisicaoDTO);
        repository.save(newCliente);
        return mapper.paraRespostaDTO(newCliente);
    }

    public void excluir(Long id){
        if(!repository.existsById(id)){
            throw new ClienteNaoExisteException();
        }

        repository.deleteById(id);
    }
}
