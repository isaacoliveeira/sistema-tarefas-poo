package com.mycompany.gerenciadordetarefas.model;

import com.mycompany.gerenciadordetarefas.controller.TarefaRepository;


import java.util.List;
import java.util.Optional;

public class TarefaService {
    private TarefaRepository tarefaPersistence;
    public TarefaService(TarefaRepository tarefaPersistence) {
        this.tarefaPersistence = tarefaPersistence;
    }

    public List<Tarefa> carregarTarefas(String usuario)  {
        return TarefaRepository.carregarTarefas(usuario);
    }

    public void cadastrarTarefa(Tarefa tarefaEditada)  {
        List<Tarefa> todasAsTarefas = carregarTarefas(tarefaEditada.getUsuario());

        if (todasAsTarefas != null) {
            Optional<Tarefa> tarefaOriginal = todasAsTarefas.stream()
                    .filter(t -> t.getTitulo().equals(tarefaEditada.getTitulo()))
                    .findFirst();

            tarefaOriginal.ifPresent(original -> {
                original.setDescricao(tarefaEditada.getDescricao());
                original.setDataConclusao(tarefaEditada.getDataConclusao());
                original.setConcluida(tarefaEditada.isConcluida());
                original.setImportancia(tarefaEditada.getImportancia());
            });

            tarefaPersistence.salvarTarefas(todasAsTarefas);
        } else {
            System.err.println("Não foi possível carregar as tarefas");
        }
    }

    public static void excluirTarefa(List<Tarefa> tarefas, String titulo) {
        tarefas.removeIf(tarefa -> tarefa.getTitulo().equals(titulo));
    }
}

