package com.weg.gestao_loja.mapper;

import com.weg.gestao_loja.dto.produto.ProdutoRequisicaoDTO;
import com.weg.gestao_loja.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto paraEntidade(ProdutoRequisicaoDTO requisicaoDTO){
        return new Produto(requisicaoDTO.nome(),
                requisicaoDTO.descricao(),
                requisicaoDTO.preco(),
                requisicaoDTO.quantidade());
    }
}
