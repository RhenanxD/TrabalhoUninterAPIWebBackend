package com.rhenan.tarefas_api_backend.controller;

// Projeto de API para gerenciamento de tarefas com consultas, verificacao, id, removedor de tarefas feito por Rhenan Henrique Leite - 4847946 para a Uninter

import com.rhenan.tarefas_api_backend.model.Tarefa;
import com.rhenan.tarefas_api_backend.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    // Criar uma tarefa nova
    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        if (tarefa.getNome() == null || tarefa.getNome().isEmpty()) {  // Somente para verificacao caso aconteca algo para a tarefa estar vazia error checker basicamente
            System.out.println("Nome da tarefa está vazia, verificar o motivo!");
        }
    	System.out.println("Criando Tarefa (Verificacao): " + tarefa.getNome()); // Verificar se a tarefa foi criada no console, somente para fins de verificação
        return repository.save(tarefa);
    }

    // Consultar todas as tarefas cadastradas
    @GetMapping
    public List<Tarefa> consultarTodas() {
    	System.out.println("Consultando todas as tarefas (Verificacao)"); // Consultar todas as tarefas se estão corretas
        return repository.findAll();
    }

    // Consultar uma tarefa especifica pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> consultarPorId(@PathVariable Long id) {
    	System.out.println("Consultando tarefa por ID (Verificacao): " + id); // Verificando se a consulta de tarefa por id esta indo de acordo com o esperado
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar uma tarefa existente
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa novaTarefa) {
    	System.out.println("Atualizando Tarefa (Verificacao): ID " + id + " → Novo nome: " + novaTarefa.getNome()); // Verificar se tarefa esta atualizando conforme o esperado
        return repository.findById(id)
                .map(tarefa -> {
                    tarefa.setNome(novaTarefa.getNome());
                    tarefa.setDataEntrega(novaTarefa.getDataEntrega());
                    tarefa.setResponsavel(novaTarefa.getResponsavel());
                    return ResponseEntity.ok(repository.save(tarefa));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Remover uma tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerTarefa(@PathVariable Long id) {
    	System.out.println("Removendo Tarefa (Verificacao): ID " + id); // Remover a tarefa, só verificando para fins no console
        return repository.findById(id)
                .map(tarefa -> {
                    repository.delete(tarefa);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
