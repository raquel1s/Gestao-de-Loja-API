package com.weg.gestao_loja.repository;

import com.weg.gestao_loja.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    boolean existsByCnpj(String cnpj);
    boolean existsByEmail(String email);
}
