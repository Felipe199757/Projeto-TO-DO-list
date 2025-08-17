package com.example.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Tarefa implements Serializable {
    
    public enum Status { PENDENTE, CONCLUIDA }

    private String titulo;
    private String descricao;
    private Status status;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao;

    public Tarefa(String titulo, String descricao, Status status, LocalDate dataCriacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public LocalDate getDataConclusao() { return dataConclusao; }
    public void setDataConclusao(LocalDate dataConclusao) { this.dataConclusao = dataConclusao; }

    @Override
    public String toString() {
        return "Tarefa [titulo=" + titulo + ", descricao=" + descricao + ", status=" + status +
               ", criada em=" + dataCriacao + ", concluída em=" + dataConclusao + "]";
    }
}
