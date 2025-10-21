package com.weg.gestao_loja.service;

import com.weg.gestao_loja.dto.fornecedor.FornecedorRequisicaoDTO;
import com.weg.gestao_loja.dto.fornecedor.FornecedorRespostaDTO;
import com.weg.gestao_loja.exception.fornecedor.FornecedorCadastradoException;
import com.weg.gestao_loja.exception.fornecedor.FornecedorNaoExisteException;
import com.weg.gestao_loja.mapper.FornecedorMapper;
import com.weg.gestao_loja.model.Fornecedor;
import com.weg.gestao_loja.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FornecedorService {

    private final FornecedorRepository repository;
    private final FornecedorMapper mapper;

    public FornecedorRespostaDTO criar(FornecedorRequisicaoDTO requisicaoDTO){
        if(repository.existsByEmail(requisicaoDTO.email())){
            throw new FornecedorCadastradoException("Email já cadastrado!");
        }

        if(repository.existsByCnpj(requisicaoDTO.cnpj())){
            throw new FornecedorCadastradoException("CNPJ já cadastrado!");
        }

        return mapper.paraRespostaDTO(repository.save(mapper.paraEntidade(requisicaoDTO)));
    }

    public List<FornecedorRespostaDTO> buscarTodos(){
        return repository.findAll().stream().map(mapper::paraRespostaDTO).toList();
    }

    public FornecedorRespostaDTO buscarPorId(Long id){
        return mapper.paraRespostaDTO(repository.findById(id).orElseThrow(() -> {
            throw new FornecedorNaoExisteException();
        }));
    }

    public FornecedorRespostaDTO atualizar(Long id, FornecedorRequisicaoDTO requisicaoDTO){
        Fornecedor fornecedor = repository.findById(id).orElseThrow(() -> {
            throw new FornecedorNaoExisteException();
        });

        Fornecedor newFornecedor = mapper.paraUpdate(fornecedor, requisicaoDTO);
        repository.save(newFornecedor);
        return mapper.paraRespostaDTO(newFornecedor);
    }

    public void excluir(Long id){
        if(!repository.existsById(id)){
            throw new FornecedorNaoExisteException();
        }

        repository.deleteById(id);
    }
}
