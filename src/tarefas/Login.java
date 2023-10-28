package tarefas;

import java.util.Scanner;

public class Login {

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
