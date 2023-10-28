package tarefas;

import java.util.Scanner;

public class Main extends Login{
    public static void main(String[] args) throws TarefaException {
        Scanner scanner = new Scanner(System.in);
        GerenciadorTarefas gerenciador = new Dados("tarefas.csv");
        Usuario usuario = new Usuario();

        while (true) {
            exibirOpcoes();
            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    fazerLogin(scanner, usuario);
                    break;
                case 2:
                    criarNovoLogin(scanner, usuario);
                    break;
                default:
                    System.out.println("Opção inválida. Escolha 1 para fazer login ou 2 para criar um novo login.");
            }

            if (usuario.estaLogado()) {
                menuOperacoes(scanner, gerenciador, usuario);
                break;
            }
        }
    }

    private static void menuOperacoes(Scanner scanner, GerenciadorTarefas gerenciador, Usuario usuario) throws TarefaException {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    criarTarefa(gerenciador, scanner);
                    break;
                case 2:
                    removerTarefa(gerenciador, scanner);
                    break;
                case 3:
                    listarTarefas(gerenciador);
                    break;
                case 4:
                    buscarTarefas(gerenciador, scanner);
                    break;
                case 5:
                    alterarStatusTarefa(gerenciador, scanner);
                    break;
                case 6:
                    System.out.println("Desconectando...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void criarTarefa(GerenciadorTarefas gerenciador, Scanner scanner) {
        try {
            System.out.print("Digite o título da tarefa: ");
            String titulo = scanner.nextLine();
            System.out.print("Digite a descrição da tarefa: ");
            String descricao = scanner.nextLine();
            System.out.print("Digite o status da tarefa ('Concluida', 'Nao Concluida' ou 'Em Andamento'): ");
            String status = scanner.nextLine();
            System.out.print("Digite o prazo da tarefa (no formato dd/MM/aaaa): ");
            String prazo = scanner.nextLine();

            gerenciador.criarTarefa(titulo, descricao, status, prazo);
        } catch (TarefaException e) {
            System.err.println("Erro ao criar a tarefa: " + e.getMessage());
        }
    }

    public static void alterarStatusTarefa(GerenciadorTarefas gerenciador, Scanner scanner) {
        try {
            System.out.print("Digite o ID da tarefa que deseja alterar o status: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            System.out.print("Digite o novo status da tarefa ('Concluida', 'Nao Concluida' ou 'Em Andamento'): ");
            String novoStatus = scanner.nextLine();

            gerenciador.alterarStatusTarefa(id, novoStatus);
        } catch (TarefaException e) {
            System.err.println("Erro ao alterar o status da tarefa: " + e.getMessage());
        }
    }

    public static void exibirOpcoes() {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Fazer login");
            System.out.println("2. Criar um novo login");
            System.out.print("Opção: ");
        }

    public static void exibirMenu() {
        System.out.println("----- MENU -----");
        System.out.println("1. Criar Tarefa");
        System.out.println("2. Remover Tarefa");
        System.out.println("3. Listar Tarefas");
        System.out.println("4. Buscar Tarefas");
        System.out.println("5. Alterar Status da Tarefa");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }
}
