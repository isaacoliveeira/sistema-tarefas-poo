package tarefas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorTarefas gerenciador = new ControleDeTarefas("tarefas.csv");
        Menu tarefas = new Menu(gerenciador, scanner);

        while (true) {
            tarefas.mostrarMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            tarefas.processarOpcao(opcao);
            // Salvar as tarefas no arquivo CSV após cada operação, se necessário
            gerenciador.salvarTarefasEmArquivoCSV("tarefas.csv");
        }
    }
}