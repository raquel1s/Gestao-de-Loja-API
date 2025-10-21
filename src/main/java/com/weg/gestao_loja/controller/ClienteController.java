package com.weg.gestao_loja.controller;

import com.weg.gestao_loja.dto.cliente.ClienteRequisicaoDTO;
import com.weg.gestao_loja.dto.cliente.ClienteRespostaDTO;
import com.weg.gestao_loja.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteRespostaDTO> criar(@RequestBody ClienteRequisicaoDTO requisicaoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(requisicaoDTO));
    }

    @GetMapping
    public ResponseEntity<List<ClienteRespostaDTO>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteRespostaDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteRespostaDTO> atualizar(@PathVariable Long id,
                                                        @RequestBody ClienteRequisicaoDTO requisicaoDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id, requisicaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
