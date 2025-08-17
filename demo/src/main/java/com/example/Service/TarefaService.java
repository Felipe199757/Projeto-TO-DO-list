package com.example.Service;

import com.example.Model.Tarefa;
import com.example.Repository.TarefaRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public void adicionar(String titulo, String descricao) throws IOException {
        Tarefa tarefa = new Tarefa(titulo, descricao, Tarefa.Status.PENDENTE, LocalDate.now());
        repository.salvar(tarefa);
    }

    public void listar() throws IOException, ClassNotFoundException {
        List<Tarefa> tarefas = repository.listar();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa salva ainda");
        } else {
            tarefas.forEach(System.out::println);
        }
    }

    public void editarCampo(String titulo, String novoValor, String campo)
            throws IOException, ClassNotFoundException {
        List<Tarefa> tarefas = repository.listar();
        boolean encontrada = false;

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                encontrada = true;
                switch (campo.toLowerCase()) {
                    case "descricao":
                        tarefa.setDescricao(novoValor);
                        break;
                    case "status":
                        try {
                            Tarefa.Status novoStatus = Tarefa.Status.valueOf(novoValor.toUpperCase());
                            tarefa.setStatus(novoStatus);
                            tarefa.setDataConclusao(
                                    novoStatus == Tarefa.Status.CONCLUIDA ? LocalDate.now() : null);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Status inválido. Valores permitidos: " + Arrays.toString(Tarefa.Status.values()));
                            return;
                        }
                        break;
                    case "titulo":
                        tarefa.setTitulo(novoValor);
                        break;
                    default:
                        System.out.println("Campo inválido.");
                        return;
                }
            }
        }

        if (!encontrada) {
            System.out.println("Tarefa não encontrada.");
            return;
        }

        repository.salvarTodas(tarefas);
        System.out.println("Tarefa atualizada com sucesso!");
    }

    public void remover(String titulo) throws IOException, ClassNotFoundException {
        List<Tarefa> tarefas = repository.listar();
        boolean removida = tarefas.removeIf(t -> t.getTitulo().equalsIgnoreCase(titulo));

        if (!removida) {
            System.out.println("Tarefa não encontrada.");
            return;
        }

        repository.salvarTodas(tarefas);
        System.out.println("Tarefa removida com sucesso!");
    }

    public void filtrarPorStatus(String status) throws IOException, ClassNotFoundException {
        List<Tarefa> tarefas = repository.listar();
        tarefas.stream()
                .filter(t -> t.getStatus().name().equalsIgnoreCase(status))
                .forEach(System.out::println);
    }
}
