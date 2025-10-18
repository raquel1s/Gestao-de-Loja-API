package com.weg.gestao_loja.controller;

import com.weg.gestao_loja.dto.produto.ProdutoRequisicaoDTO;
import com.weg.gestao_loja.dto.produto.ProdutoRespostaDTO;
import com.weg.gestao_loja.service.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoRespostaDTO> criar(@RequestBody ProdutoRequisicaoDTO requisicaoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(requisicaoDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoRespostaDTO>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoRespostaDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoRespostaDTO> atualizar(@PathVariable Long id,
                                                        @RequestBody ProdutoRequisicaoDTO requisicaoDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id, requisicaoDTO));
    }
}
