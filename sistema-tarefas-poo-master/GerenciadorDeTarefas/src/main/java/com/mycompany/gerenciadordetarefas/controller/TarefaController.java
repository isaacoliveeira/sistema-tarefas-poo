package com.mycompany.gerenciadordetarefas.controller;


import com.mycompany.gerenciadordetarefas.model.Tarefa;
import com.mycompany.gerenciadordetarefas.model.TarefaService;

import java.util.List;
public class TarefaController {
    private List<Tarefa> tarefas;
    TarefaRepository tarefaRepository = new TarefaRepository();

    TarefaService tarefaService = new TarefaService(tarefaRepository);


    public String validarData(String data) throws DataInvalidaException {
        return DataValidator.validarData(data);
    }

    public void removerTarefa(String usuario, String titulo) {
        List<Tarefa> tarefas = TarefaRepository.carregarTarefas(usuario);

        if (tarefas != null) {
            TarefaService.excluirTarefa(tarefas, titulo);
            tarefaRepository.salvarTarefas(tarefas);
        } else {
            System.err.println("Não foi possível remover tarefa");
        }
    }
    

    public void cadastrarTarefa(Tarefa tarefa)  {
        tarefaService.cadastrarTarefa(tarefa);
    }

}