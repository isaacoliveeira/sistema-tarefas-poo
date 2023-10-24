package tarefas;

import java.time.format.DateTimeFormatter;
import java.util.List;

public interface GerenciadorTarefas {
    void adicionarTarefa(Tarefa tarefa) throws PrioridadeInvalidaException, DataInvalidaException;
    void editarTarefa(String titulo, Tarefa novaTarefa) throws IllegalArgumentException;
    void removerTarefa(String titulo);
    List<Tarefa> listarTarefas();
    void marcarStatusTarefa(String titulo, String novoStatus);
    List<Tarefa> buscarTarefas(String termo);
    boolean dataValida(String data);
    DateTimeFormatter getFormatter();

    Tarefa buscarTarefaPorTitulo(String tituloEditar);
}
