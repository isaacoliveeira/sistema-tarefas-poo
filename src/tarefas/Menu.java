package tarefas;

import java.util.Scanner;

public class Menu extends Usuario {

    public Menu(GerenciadorTarefas gerenciador, Scanner scanner) {
        super(gerenciador, scanner);
    }

    public void mostrarMenu() {
        System.out.println("----- OPÇÕES -----");
        System.out.println("\r1. Adicionar Tarefa");
        System.out.println("\r2. Editar Tarefa");
        System.out.println("\r3. Remover Tarefa");
        System.out.println("\r4. Listar Tarefas");
        System.out.println("\r5. Alterar Status da Tarefa");
        System.out.println("\r6. Buscar Tarefas");
        System.out.println("\r7. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarTarefa();
                break;

            case 2:
                editarTarefa();
                break;

            case 3:
                removerTarefa();
                break;

            case 4:
                listarTarefas();
                break;

            case 5:
                marcarStatusTarefa();
                break;

            case 6:
                buscarTarefas();
                break;

            case 7:
                System.out.println("Saindo do sistema.");
                System.exit(0);
                break;

            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
        }
    }
}
   