package com.rhenan.tarefas_api_backend.repository;

// Repositorio da Tarefa - Para Fornecer acesso ao banco de dados

import com.rhenan.tarefas_api_backend.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
