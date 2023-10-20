package tarefas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tarefa{
    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private String prioridade;
    private String status;

    public Tarefa(String titulo, String descricao, LocalDate prazo, String prioridade, String status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.prioridade = prioridade;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Tarefa: " + titulo + "\nDescrição: " + descricao + "\nPrazo: " + prazo.format(formatter) +
                "\nPrioridade: " + prioridade + "\nStatus: " + status;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getPrazo() {
        return prazo;
    }
}

