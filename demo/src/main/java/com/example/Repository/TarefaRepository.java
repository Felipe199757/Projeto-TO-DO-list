package com.example.Repository;

import com.example.Model.Tarefa;
import java.io.IOException;
import java.util.List;

public interface TarefaRepository {
    void salvar(Tarefa tarefa) throws IOException;
    List<Tarefa> listar() throws IOException, ClassNotFoundException;
    void salvarTodas(List<Tarefa> tarefas) throws IOException;
}
