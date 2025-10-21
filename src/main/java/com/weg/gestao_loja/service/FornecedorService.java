package com.weg.gestao_loja.service;

import com.weg.gestao_loja.mapper.FornecedorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FornecedorService {

    private final FornecedorService service;
    private final FornecedorMapper mapper;
}
