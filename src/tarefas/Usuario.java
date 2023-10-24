package tarefas;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;

public class Usuario {
    private GerenciadorTarefas gerenciador;
    private Scanner scanner;

    public Usuario(GerenciadorTarefas gerenciador, Scanner scanner) {
        this.gerenciador = gerenciador;
        this.scanner = scanner;
    }

    public void adicionarTarefa() {
        System.out.print("Digite o título da tarefa: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();

        LocalDate prazo = null;
        while (prazo == null) {
            System.out.print("Digite o prazo da tarefa (formato: dd/MM/yyyy): ");
            String dataPrazo = scanner.nextLine();
            if (gerenciador.dataValida(dataPrazo)) {
                prazo = LocalDate.parse(dataPrazo, gerenciador.getFormatter());
            } else {
                System.out.println("A data deve ser igual ou posterior à data atual.");
            }
        }

        System.out.print("Digite a prioridade da tarefa (Alta/Média/Baixa): ");
        String prioridade = scanner.nextLine();

        System.out.print("Digite o status da tarefa (Em andamento/Não concluída/Concluída): ");
        String status = scanner.nextLine();

        Tarefa novaTarefa = new Tarefa(titulo, descricao, prazo, prioridade, status);
        try {
            gerenciador.adicionarTarefa(novaTarefa);
            System.out.println("Tarefa adicionada com sucesso!");
        } catch (PrioridadeInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (DataInvalidaException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarTarefa() {
        System.out.print("Digite o título da tarefa a ser editada: ");
        String tituloEditar = scanner.nextLine();

        Tarefa tarefaParaEditar = gerenciador.buscarTarefaPorTitulo(tituloEditar);
        if (tarefaParaEditar != null) {
            System.out.print("Digite o novo título da tarefa: ");
            tarefaParaEditar.setTitulo(scanner.nextLine());

            System.out.print("Digite a nova descrição da tarefa: ");
            tarefaParaEditar.setDescricao(scanner.nextLine());

            LocalDate novoPrazo = null;
            while (novoPrazo == null) {
                System.out.print("Digite o novo prazo da tarefa (formato: dd/MM/yyyy): ");
                String dataPrazo = scanner.nextLine();
                if (gerenciador.dataValida(dataPrazo)) {
                    novoPrazo = LocalDate.parse(dataPrazo, gerenciador.getFormatter());
                } else {
                    System.out.println("A data deve ser igual ou posterior à data atual.");
                }
            }
            tarefaParaEditar.setPrazo(novoPrazo);

            System.out.print("Digite a nova prioridade da tarefa (Alta/Média/Baixa): ");
            tarefaParaEditar.setPrioridade(scanner.nextLine());

            System.out.print("Digite o novo status da tarefa (Em andamento/Não concluída/Concluída): ");
            tarefaParaEditar.setStatus(scanner.nextLine());

            gerenciador.editarTarefa(tituloEditar, tarefaParaEditar);
            System.out.println("Tarefa editada com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada: " + tituloEditar);
        }
    }

    public void removerTarefa() {
        System.out.print("Digite o título da tarefa a ser removida: ");
        String tituloRemover = scanner.nextLine();
        gerenciador.removerTarefa(tituloRemover);
        System.out.println("Tarefa removida com sucesso!");
    }

    public void listarTarefas() {
        List<Tarefa> tarefas = gerenciador.listarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            System.out.println("Tarefas cadastradas:");
            for (Tarefa tarefa : tarefas) {
                System.out.println(tarefa);
            }
        }
    }

    public void marcarStatusTarefa() {
        System.out.print("Digite o título da tarefa a ser atualizada: ");
        String tituloStatus = scanner.nextLine();
        System.out.print("Digite o novo status da tarefa (Em andamento/Não concluída/Concluída): ");
        String novoStatus = scanner.nextLine();
        gerenciador.marcarStatusTarefa(tituloStatus, novoStatus);
        System.out.println("Status da tarefa atualizado com sucesso!");
    }

    public void buscarTarefas() {
        System.out.print("Digite o termo de busca: ");
        String termoBusca = scanner.nextLine();
        List<Tarefa> tarefasEncontradas = gerenciador.buscarTarefas(termoBusca);
        if (tarefasEncontradas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada com o termo: " + termoBusca);
        } else {
            System.out.println("Tarefas encontradas:");
            for (Tarefa tarefa : tarefasEncontradas) {
                System.out.println(tarefa);
            }
        }
    }
}