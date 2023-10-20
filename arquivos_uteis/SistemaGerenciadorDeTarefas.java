package tarefas;

import java.util.List;
import java.util.Scanner;

public class SistemaGerenciadorDeTarefas {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Criar usuário");
            System.out.println("2. Fazer login");
            System.out.println("3. Fazer logout");
            System.out.println("4. Adicionar tarefa");
            System.out.println("5. Listar tarefas");
            System.out.println("6. Atualizar status da tarefa");
            System.out.println("7. Remover tarefa");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Nome de usuário: ");
                    String nomeUsuario = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
                    gerenciadorTarefas.criarUsuario(nomeUsuario, senha);
                    System.out.println("Usuário criado com sucesso.");
                    break;
                case 2:
                    System.out.print("Nome de usuário: ");
                    String nomeLogin = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senhaLogin = scanner.nextLine();
                    gerenciadorTarefas.login(nomeLogin, senhaLogin);
                    if (gerenciadorTarefas.getUsuarioLogado() != null) {
                        System.out.println("Login bem-sucedido.");
                    } else {
                        System.out.println("Login falhou. Verifique o nome de usuário e a senha.");
                    }
                    break;
                case 3:
                    gerenciadorTarefas.logout();
                    System.out.println("Logout realizado com sucesso.");
                    break;
                case 4:
                    if (gerenciadorTarefas.getUsuarioLogado() != null) {
                        adicionarTarefa(gerenciadorTarefas, scanner);
                    } else {
                        System.out.println("Faça login antes de adicionar tarefas.");
                    }
                    break;
                case 5:
                    listarTarefas(gerenciadorTarefas);
                    break;
                case 6:
                    if (gerenciadorTarefas.getUsuarioLogado() != null) {
                        atualizarStatusTarefa(gerenciadorTarefas, scanner);
                    } else {
                        System.out.println("Faça login antes de atualizar tarefas.");
                    }
                    break;
                case 7:
                    if (gerenciadorTarefas.getUsuarioLogado() != null) {
                        removerTarefa(gerenciadorTarefas, scanner);
                    } else {
                        System.out.println("Faça login antes de remover tarefas.");
                    }
                    break;
                case 8:
                    System.out.println("Saindo do sistema.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarTarefa(GerenciadorTarefas gerenciadorTarefas, Scanner scanner) {
        System.out.print("Título da tarefa: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição da tarefa: ");
        String descricao = scanner.nextLine();
        System.out.print("Prazo de conclusão: ");
        String prazoConclusao = scanner.nextLine();
        System.out.print("Prioridade (1-Alta, 2-Média, 3-Baixa): ");
        int prioridade = scanner.nextInt();
        scanner.nextLine();
        gerenciadorTarefas.adicionarTarefa(titulo, descricao, prazoConclusao, prioridade);
        System.out.println("Tarefa adicionada com sucesso.");
    }

    private static void listarTarefas(GerenciadorTarefas gerenciadorTarefas) {
        List<Tarefas> tarefas = gerenciadorTarefas.listarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Não existem tarefas para listar.");
        } else {
            for (Tarefas tarefa : tarefas) {
                System.out.println("Título: " + tarefa.getTitulo());
                System.out.println("Descrição: " + tarefa.getDescricao());
                System.out.println("Prazo de conclusão: " + tarefa.getPrazoConclusao());
                System.out.println("Prioridade: " + tarefa.getPrioridade());
                System.out.println("Status: " + tarefa.getStatus());
                System.out.println();
            }
        }
    }

    private static void atualizarStatusTarefa(GerenciadorTarefas gerenciadorTarefas, Scanner scanner) {
        System.out.print("Título da tarefa que deseja atualizar: ");
        String titulo = scanner.nextLine();
        Tarefas tarefa = buscarTarefa(gerenciadorTarefas, titulo);
        if (tarefa != null) {
            System.out.print("Novo status (A fazer, Em andamento, Concluída): ");
            String novoStatus = scanner.nextLine();
            gerenciadorTarefas.atualizarStatusTarefa(tarefa, novoStatus);
            System.out.println("Status atualizado com sucesso.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private static void removerTarefa(GerenciadorTarefas gerenciadorTarefas, Scanner scanner) {
        System.out.print("Título da tarefa que deseja remover: ");
        String titulo = scanner.nextLine();
        Tarefas tarefa = buscarTarefa(gerenciadorTarefas, titulo);
        if (tarefa != null) {
            gerenciadorTarefas.removerTarefa(tarefa);
            System.out.println("Tarefa removida com sucesso.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private static Tarefas buscarTarefa(GerenciadorTarefas gerenciadorTarefas, String titulo) {
        List<Tarefas> tarefas = gerenciadorTarefas.listarTarefas();
        for (Tarefas tarefa : tarefas) {
            if (tarefa.getTitulo().equals(titulo)) {
                return tarefa;
            }
        }
        return null;
    }
}