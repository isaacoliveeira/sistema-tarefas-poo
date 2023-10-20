package tarefas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new ControleDeTarefas();
        Scanner scanner = new Scanner(System.in);
        TarefaInterfaceUsuario tarefaIU = new TarefaInterfaceUsuario(gerenciador, scanner);


        while (true) {
            tarefaIU.mostrarMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            tarefaIU.processarOpcao(opcao);
        }
    }
}
