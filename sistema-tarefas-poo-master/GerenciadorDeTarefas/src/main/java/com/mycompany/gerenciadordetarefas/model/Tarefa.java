package com.mycompany.gerenciadordetarefas.model;

import java.util.Objects;

public class Tarefa {
    private String usuario;
    private String descricao;
    private String titulo;
    private String dataConclusao;
    private boolean concluida;
    private String importancia;

    public Tarefa(String usuario, String titulo, String descricao, String dataConclusao, boolean concluida, String importancia) {
        this.usuario = usuario;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataConclusao = dataConclusao;
        this.concluida = concluida;
        this.importancia = importancia;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public boolean setStatus(boolean concluída) {
        return concluida;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tarefa tarefa = (Tarefa) obj;
        return Objects.equals(titulo, tarefa.titulo) && Objects.equals(descricao, tarefa.descricao);
    }

    @Override
    public String toString() {
        return getTitulo() + " - " + getDescricao() + " (Conclusão em: " + getDataConclusao() + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, descricao);
    }
}