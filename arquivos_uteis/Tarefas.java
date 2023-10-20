package tarefas;

public class Tarefas {
    private String titulo;
    private String descricao;
    private String prazoConclusao;
    private int prioridade;
    private String status;

    public Tarefas(String titulo, String descricao, String prazoConclusao, int prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazoConclusao = prazoConclusao;
        this.prioridade = prioridade;
        this.status = "A fazer";
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPrazoConclusao() {
        return prazoConclusao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }
}
