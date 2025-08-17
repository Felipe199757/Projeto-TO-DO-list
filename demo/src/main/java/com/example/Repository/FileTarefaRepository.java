package com.example.Repository;

import com.example.Model.Tarefa;
import com.example.Util.AppendableObjectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTarefaRepository implements TarefaRepository {

    private final File fileName = new File("tarefas.dat");

    @Override
    public void salvar(Tarefa tarefa) throws IOException {
        boolean append = fileName.exists();
        try (ObjectOutputStream oos = append
                ? new AppendableObjectOutputStream(new FileOutputStream(fileName, true))
                : new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tarefa);
        }
    }

    @Override
    public List<Tarefa> listar() throws IOException, ClassNotFoundException {
        List<Tarefa> tarefas = new ArrayList<>();
        if (!fileName.exists()) return tarefas;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    tarefas.add((Tarefa) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        }
        return tarefas;
    }

    @Override
    public void salvarTodas(List<Tarefa> tarefas) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Tarefa t : tarefas) {
                oos.writeObject(t);
            }
        }
    }
}
