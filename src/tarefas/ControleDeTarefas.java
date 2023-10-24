package tarefas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ControleDeTarefas implements GerenciadorTarefas {
    private List<Tarefa> tarefas = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void adicionarTarefa(Tarefa tarefa) throws PrioridadeInvalidaException, DataInvalidaException {
        if (tarefa.getPrioridade().equalsIgnoreCase("Alta") ||
                tarefa.getPrioridade().equalsIgnoreCase("Média") ||
                tarefa.getPrioridade().equalsIgnoreCase("Baixa")) {
            if (dataValida(tarefa.getPrazo().format(formatter))) {
                tarefas.add(tarefa);
            } else {
                throw new DataInvalidaException("Data de prazo inválida. Deve ser igual ou posterior à data atual.");
            }
        } else {
            throw new PrioridadeInvalidaException("Prioridade inválida.");
        }
    }

    @Override
    public void editarTarefa(String titulo, Tarefa novaTarefa) throws IllegalArgumentException {
        Tarefa tarefaExistente = buscarTarefaPorTitulo(titulo);
        if (tarefaExistente != null) {
            tarefaExistente.setTitulo(novaTarefa.getTitulo());
            tarefaExistente.setDescricao(novaTarefa.getDescricao());
            tarefaExistente.setPrazo(novaTarefa.getPrazo());
            tarefaExistente.setPrioridade(novaTarefa.getPrioridade());
            tarefaExistente.setStatus(novaTarefa.getStatus());
        } else {
            throw new IllegalArgumentException("Tarefa não encontrada: " + titulo);
        }
    }

    @Override
    public void removerTarefa(String titulo) {
        Tarefa tarefa = buscarTarefaPorTitulo(titulo);
        if (tarefa != null) {
            tarefas.remove(tarefa);
        }
    }


    @Override
    public List<Tarefa> listarTarefas() {
        return tarefas;
    }

    @Override
    public void marcarStatusTarefa(String titulo, String novoStatus) {
        Tarefa tarefa = buscarTarefaPorTitulo(titulo);
        if (tarefa != null) {
            tarefa.setStatus(novoStatus);
        } else {
            throw new IllegalArgumentException("Tarefa não encontrada: " + titulo);
        }
    }

    @Override
    public List<Tarefa> buscarTarefas(String termo) {
        List<Tarefa> tarefasEncontradas = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().toLowerCase().contains(termo.toLowerCase()) ||
                    tarefa.getDescricao().toLowerCase().contains(termo.toLowerCase())) {
                tarefasEncontradas.add(tarefa);
            }
        }
        return tarefasEncontradas;
    }

    @Override
    public boolean dataValida(String data) {
        try {
            LocalDate dataFornecida = LocalDate.parse(data, formatter);
            return !dataFornecida.isBefore(getDataAtual());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public Tarefa buscarTarefaPorTitulo(String titulo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equals(titulo)) {
                return tarefa;
            }
        }
        return null;
    }

    public LocalDate getDataAtual() {
        return LocalDate.now();
    }
}
