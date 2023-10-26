package tarefas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorTarefas gerenciador = new Dados("tarefas.csv");
        Menu tarefas = new Menu(gerenciador, scanner);

        while (true) {
            tarefas.mostrarMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            tarefas.processarOpcao(opcao);
            gerenciador.salvarTarefasEmArquivoCSV("tarefas.csv");
        }
    }
}