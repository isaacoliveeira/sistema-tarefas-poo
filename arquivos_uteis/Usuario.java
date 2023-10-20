package tarefas;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String senha;
    private List<Tarefas> tarefas;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.tarefas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public List<Tarefas> getTarefas() {
        return tarefas;
    }
}

