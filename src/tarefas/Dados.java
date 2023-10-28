package tarefas;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Dados implements GerenciadorTarefas {
    private final String arquivo;
    private List<String> tarefas;

    public Dados(String arquivo) {
        this.arquivo = arquivo;
        this.tarefas = new ArrayList<>();
    }

    private void salvarDados() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            for (String tarefa : tarefas) {
                writer.println(tarefa);
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    @Override
    public void criarTarefa(String titulo, String descricao, String status, String prazo) throws TarefaException {
        if (titulo.isEmpty() || descricao.isEmpty() || status.isEmpty() || prazo.isEmpty()) {
            throw new TarefaException("Título, descrição, status ou prazo não podem estar vazios");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        try {
            Date dataPrazo = sdf.parse(prazo);
            Date dataAtual = new Date();

            if (dataPrazo.before(dataAtual)) {
                throw new TarefaException("A data de prazo não pode ser anterior à data atual");
            }
        } catch (ParseException e) {
            throw new TarefaException("Formato de data inválido. Use o formato dd/MM/aaaa");
        }

        String novaTarefa = String.format("Título: %s | Descrição: %s | Status: %s | Prazo: %s", titulo, descricao, status, prazo);
        tarefas.add(novaTarefa);
        salvarDados();
        System.out.println("Tarefa criada com sucesso!");
    }

    @Override
    public void criarTarefa(String titulo, String descricao, String status) throws TarefaException {
        if (titulo.isEmpty() || descricao.isEmpty() || status.isEmpty()) {
            throw new TarefaException("Título, descrição ou status não podem estar vazios");
        }

        String novaTarefa = String.format("Título: %s | Descrição: %s | Status: %s", titulo, descricao, status);
        tarefas.add(novaTarefa);
        salvarDados();
        System.out.println("Tarefa criada com sucesso!");
    }

    @Override
    public void removerTarefa(int id) {
        if (id >= 0 && id < tarefas.size()) {
            tarefas.remove(id);
            salvarDados();
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("ID de tarefa inválido.");
        }
    }

    @Override
    public List<String> listarTarefas() {
        return new ArrayList<>(tarefas);
    }

    @Override
    public List<String> buscarTarefas(String termo) {
        List<String> tarefasEncontradas = new ArrayList<>();
        for (String tarefa : tarefas) {
            if (tarefa.contains(termo)) {
                tarefasEncontradas.add(tarefa);
            }
        }
        return tarefasEncontradas;
    }
    @Override
    public void alterarStatusTarefa(int id, String novoStatus) throws TarefaException {
        if (id < 0 || id >= tarefas.size()) {
            throw new TarefaException("ID de tarefa inválido");
        }

        String tarefa = tarefas.get(id);
        String[] dadosTarefa = tarefa.split("\\|");
        if (dadosTarefa.length < 3) {
            throw new TarefaException("Dados da tarefa estão incompletos");
        }

        String prazo = dadosTarefa[3].trim();
        if (novoStatus.equalsIgnoreCase("concluida") || novoStatus.equalsIgnoreCase("nao concluida") || novoStatus.equalsIgnoreCase("em andamento")) {
            tarefas.set(id, String.format("Título: %s | Descrição: %s | Status: %s | Prazo: %s", dadosTarefa[0], dadosTarefa[1], novoStatus, prazo));
            salvarDados();
            System.out.println("Status da tarefa alterado com sucesso!");
        } else {
            throw new TarefaException("Opção de status inválida. Use 'Concluida', 'Nao Concluida' ou 'Em Andamento'");
        }
    }
}
