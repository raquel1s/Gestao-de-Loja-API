package com.weg.gestao_loja.service;

import com.weg.gestao_loja.dto.categoria.CategoriaRequisicaoDTO;
import com.weg.gestao_loja.dto.categoria.CategoriaRespostaDTO;
import com.weg.gestao_loja.exception.CategoriaCadastradaException;
import com.weg.gestao_loja.exception.CategoriaNaoExisteException;
import com.weg.gestao_loja.mapper.CategoriaMapper;
import com.weg.gestao_loja.model.Categoria;
import com.weg.gestao_loja.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    public CategoriaRespostaDTO criar(CategoriaRequisicaoDTO requisicaoDTO){
        if(repository.existsByNome(requisicaoDTO.nome())){
            throw new CategoriaCadastradaException();
        }

        return mapper.paraRespostaDTO(repository.save(mapper.paraEntidade(requisicaoDTO)));
    }

    public List<CategoriaRespostaDTO> buscarTodos(){
        return repository.findAll().stream().map(mapper::paraRespostaDTO).toList();
    }

    public CategoriaRespostaDTO buscarPorId(Long id){
        Categoria categoria = repository.findById(id).orElseThrow(() -> {
            throw new CategoriaNaoExisteException();
        });

        return mapper.paraRespostaDTO(categoria);
    }

    public CategoriaRespostaDTO atualizar(Long id,CategoriaRequisicaoDTO requisicaoDTO){
        Categoria categoria = repository.findById(id).orElseThrow(() -> {
            throw new CategoriaNaoExisteException();
        });

        Categoria newCategoria = mapper.paraUpdate(categoria, requisicaoDTO);
        repository.save(newCategoria);
        return mapper.paraRespostaDTO(newCategoria);
    }

    public void excluir(Long id){
        if(!repository.existsById(id)){
            throw new CategoriaNaoExisteException();
        }

        repository.deleteById(id);
    }
}
