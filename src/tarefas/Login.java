package tarefas;

import java.util.List;
import java.util.Scanner;

public class Login {

    private Scanner scanner = new Scanner(System.in);
    private GerenciadorTarefas gerenciador = new Dados("tarefas.csv");
    private Usuario usuario = new Usuario();

    public static void removerTarefa(GerenciadorTarefas gerenciador, Scanner scanner) throws TarefaException {
        System.out.print("Digite o ID da tarefa a ser removida: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        gerenciador.removerTarefa(id);
    }

    public static void listarTarefas(GerenciadorTarefas gerenciador) throws TarefaException {
        List<String> tarefas = gerenciador.listarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas para exibir.");
        } else {
            System.out.println("Lista de Tarefas:");
            for (String tarefa : tarefas) {
                System.out.println(tarefa);
            }
        }
    }

    public static void buscarTarefas(GerenciadorTarefas gerenciador, Scanner scanner) throws TarefaException {
        System.out.print("Digite o termo a ser buscado: ");
        String termo = scanner.nextLine();
        List<String> tarefasEncontradas = gerenciador.buscarTarefas(termo);
        if (tarefasEncontradas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada com o termo especificado.");
        } else {
            System.out.println("Tarefas encontradas:");
            for (String tarefa : tarefasEncontradas) {
                System.out.println(tarefa);
            }
        }
    }

    public static void alterarSenha(Scanner scanner, Usuario usuario) {
        System.out.print("Digite a senha atual: ");
        String senhaAtual = scanner.nextLine();
        System.out.print("Digite a nova senha: ");
        String novaSenha = scanner.nextLine();

        if (usuario.alterarSenha(senhaAtual, novaSenha)) {
            System.out.println("Senha alterada com sucesso!");
        } else {
            System.out.println("Não foi possível alterar a senha. Verifique a senha atual.");
        }
    }
    public static void exibirOpcoes() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Fazer login");
        System.out.println("2. Criar um novo login");
        System.out.print("Opção: ");
    }

    public static void fazerLogin(Scanner scanner, Usuario usuario) {
        System.out.print("Digite o seu nome de usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite a sua senha: ");
        String senhaUsuario = scanner.nextLine();

        if (usuario.fazerLogin(nomeUsuario, senhaUsuario)) {
            System.out.println("Login bem-sucedido. Bem-vindo!");
        } else {
            System.out.println("Login falhou. Verifique seu nome de usuário e senha.");
        }
    }

    public static void criarNovoLogin(Scanner scanner, Usuario usuario) {
        System.out.print("Digite o nome de usuário desejado: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite a senha desejada: ");
        String senhaUsuario = scanner.nextLine();

        if (usuario.criarUsuario(nomeUsuario, senhaUsuario)) {
            System.out.println("Cadastro realizado com sucesso!");
        } else {
            System.out.println("Nome de usuário já existente. Tente outro nome de usuário.");
        }
    }
}
