package com.weg.gestao_loja.controller;

import com.weg.gestao_loja.dto.categoria.CategoriaRequisicaoDTO;
import com.weg.gestao_loja.dto.categoria.CategoriaRespostaDTO;
import com.weg.gestao_loja.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
public class CategoriaController {

    private final CategoriaService service;

    @PostMapping
    public ResponseEntity<CategoriaRespostaDTO> criar(@RequestBody CategoriaRequisicaoDTO requisicaoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(requisicaoDTO));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaRespostaDTO>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaRespostaDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaRespostaDTO> atualizar(@PathVariable Long id,
                                                          @RequestBody CategoriaRequisicaoDTO requisicaoDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id, requisicaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
