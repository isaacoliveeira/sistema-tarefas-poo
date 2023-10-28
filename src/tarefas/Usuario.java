package tarefas;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private Map<String, String> credenciais;
    private boolean logado;

    public Usuario() {
        this.credenciais = new HashMap<>();
        this.logado = false;
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

    public boolean alterarSenha(String senhaAtual, String novaSenha) {
        if (logado) {
            String senhaArmazenada = credenciais.get(getUsuarioLogado());
            if (senhaArmazenada.equals(senhaAtual)) {
                credenciais.put(getUsuarioLogado(), novaSenha);
                return true;
            }
        }
        return false;
    }

    public void efetuarLogout() {
        logado = false;
    }

    public boolean estaLogado() {
        return logado;
    }

    public String getUsuarioLogado() {
        for (Map.Entry<String, String> entry : credenciais.entrySet()) {
            if (entry.getValue().equals("true")) {
                return entry.getKey();
            }
        }
        return null;
    }
}
