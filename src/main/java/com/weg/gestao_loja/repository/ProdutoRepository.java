package com.weg.gestao_loja.repository;

import com.weg.gestao_loja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsProdutoByNome(String nome);
}
