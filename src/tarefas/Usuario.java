package tarefas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Usuario {
    private Map<String, String> credenciais;
    private boolean logado;

    public Usuario() {
        this.credenciais = new HashMap<>();
        this.logado = false;
    }

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

    public boolean criarUsuario(String nomeUsuario, String senhaUsuario) {
        if (!credenciais.containsKey(nomeUsuario)) {
            credenciais.put(nomeUsuario, senhaUsuario);
            return true;
        }
        return false;
    }

    public boolean fazerLogin(String nomeUsuario, String senhaUsuario) {
        if (credenciais.containsKey(nomeUsuario) && credenciais.get(nomeUsuario).equals(senhaUsuario)) {
            logado = true;
            return true;
        }
        return false;
    }

    public boolean estaLogado() {
        return logado;
    }
}
