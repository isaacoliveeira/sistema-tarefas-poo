package tarefas;

import java.util.List;

public interface GerenciadorTarefas {
    void criarTarefa(String titulo, String descricao, String status, String prazo) throws TarefaException;
    void removerTarefa(int id) throws TarefaException;
    List<String> listarTarefas() throws TarefaException;
    List<String> buscarTarefas(String termo) throws TarefaException;
    void alterarStatusTarefa(int id, String novoStatus) throws TarefaException;
}
