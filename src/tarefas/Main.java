package tarefas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new ControleDeTarefas();
        Scanner scanner = new Scanner(System.in);
        Views tarefas = new Views(gerenciador, scanner);

        while (true) {
            tarefas.mostrarMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            tarefas.processarOpcao(opcao);
        }
    }
}
