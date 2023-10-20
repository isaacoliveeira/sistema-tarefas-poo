package tarefas;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    private List<Usuario> usuarios;
    private Usuario usuarioLogado;

    public GerenciadorTarefas() {
        this.usuarios = new ArrayList<>();
        this.usuarioLogado = null;
    }

    public void criarUsuario(String nome, String senha) {
        Usuario novoUsuario = new Usuario(nome, senha);
        usuarios.add(novoUsuario);
    }

    public void login(String nome, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                return;
            }
        }
        usuarioLogado = null;
    }

    public void logout() {
        usuarioLogado = null;
    }

    public void adicionarTarefa(String titulo, String descricao, String prazoConclusao, int prioridade) {
        if (usuarioLogado == null) {
            System.out.println("Faça login antes de adicionar tarefas.");
            return;
        }

        Tarefas novaTarefa = new Tarefas(titulo, descricao, prazoConclusao, prioridade);
        usuarioLogado.getTarefas().add(novaTarefa);
    }

    public List<Tarefas> listarTarefas() {
        if (usuarioLogado == null) {
            System.out.println("Faça login para listar suas tarefas.");
            return new ArrayList<>();
        }

        return usuarioLogado.getTarefas();
    }

    public void atualizarStatusTarefa(Tarefas tarefa, String novoStatus) {
        if (usuarioLogado == null) {
            System.out.println("Faça login antes de atualizar tarefas.");
            return;
        }

        tarefa.atualizarStatus(novoStatus);
    }

    public void removerTarefa(Tarefas tarefa) {
        if (usuarioLogado == null) {
            System.out.println("Faça login antes de remover tarefas.");
            return;
        }

        usuarioLogado.getTarefas().remove(tarefa);
    }
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}