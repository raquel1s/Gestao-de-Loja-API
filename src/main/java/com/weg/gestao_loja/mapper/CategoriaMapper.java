package com.weg.gestao_loja.mapper;

import com.weg.gestao_loja.dto.categoria.CategoriaRequisicaoDTO;
import com.weg.gestao_loja.dto.categoria.CategoriaRespostaDTO;
import com.weg.gestao_loja.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria paraEntidade(CategoriaRequisicaoDTO requisicaoDTO){
        return new Categoria(requisicaoDTO.nome(), requisicaoDTO.descricao());
    }

    public CategoriaRespostaDTO paraRespostaDTO(Categoria categoria){
        return new CategoriaRespostaDTO(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }

    public Categoria paraUpdate(Categoria categoria, CategoriaRequisicaoDTO requisicaoDTO){
        if(!requisicaoDTO.nome().equals(categoria.getNome())){
            categoria.setNome(requisicaoDTO.nome());
        }

        if(!requisicaoDTO.descricao().equals(categoria.getDescricao())){
            categoria.setDescricao(requisicaoDTO.descricao());
        }

        return categoria;
    }
}
