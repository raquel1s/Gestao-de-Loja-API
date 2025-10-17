package com.weg.gestao_loja.mapper;

import com.weg.gestao_loja.dto.produto.ProdutoRequisicaoDTO;
import com.weg.gestao_loja.dto.produto.ProdutoRespostaDTO;
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

    public ProdutoRespostaDTO paraRespostaDTO(Produto produto){
        return new ProdutoRespostaDTO(produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getQuantidade());
    }

    public Produto paraUpdate(ProdutoRequisicaoDTO requisicaoDTO, Produto produto){
        if(!requisicaoDTO.nome().equals(produto.getNome())){
            produto.setNome(requisicaoDTO.nome());
        }

        if(!requisicaoDTO.descricao().equals(produto.getDescricao())){
            produto.setDescricao(requisicaoDTO.descricao());
        }

        if(requisicaoDTO.preco() != produto.getPreco()){
            produto.setPreco(requisicaoDTO.preco());
        }

        if(requisicaoDTO.quantidade() != produto.getQuantidade()){
            produto.setQuantidade(requisicaoDTO.quantidade());
        }

        return produto;
    }
}
