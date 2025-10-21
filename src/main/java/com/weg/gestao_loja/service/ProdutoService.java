package com.weg.gestao_loja.service;

import com.weg.gestao_loja.dto.produto.ProdutoRequisicaoDTO;
import com.weg.gestao_loja.dto.produto.ProdutoRespostaDTO;
import com.weg.gestao_loja.exception.produto.ProdutoNaoExisteException;
import com.weg.gestao_loja.mapper.ProdutoMapper;
import com.weg.gestao_loja.model.Produto;
import com.weg.gestao_loja.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoRespostaDTO criar(ProdutoRequisicaoDTO requisicaoDTO){
        return mapper.paraRespostaDTO(repository.save(mapper.paraEntidade(requisicaoDTO)));
    }

    public List<ProdutoRespostaDTO> buscarTodos() {
        return repository.findAll().stream().map(mapper::paraRespostaDTO).toList();
    }

    public ProdutoRespostaDTO buscarPorId(Long id){
        return mapper.paraRespostaDTO(repository.findById(id).orElseThrow(() -> {
            throw new ProdutoNaoExisteException();
        }));
    }

    public ProdutoRespostaDTO atualizar(Long id, ProdutoRequisicaoDTO requisicaoDTO) {
        Produto produto = repository.findById(id).orElseThrow(() -> {
            throw new ProdutoNaoExisteException();
        });

        Produto newProduto = mapper.paraUpdate(requisicaoDTO, produto);
        repository.save(newProduto);
        return mapper.paraRespostaDTO(newProduto);
    }

    public void excluir(Long id) {
        if(!repository.existsById(id)){
            throw new ProdutoNaoExisteException();
        }

        repository.deleteById(id);
    }
}
