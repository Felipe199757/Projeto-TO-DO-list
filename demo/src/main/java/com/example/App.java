package com.example;


import com.example.Repository.FileTarefaRepository;
import com.example.Repository.TarefaRepository;
import com.example.Service.TarefaService;

public class App {
    public static void main(String[] args) throws Exception {
        TarefaRepository repo = new FileTarefaRepository();

        TarefaService service = new TarefaService(repo);
        service.adicionar("estudar Java", "Estudar mais sobre a sintaxe da linguagem");
        service.listar();
        service.editarCampo("estudar Java", "Concluida", "status");
        service.filtrarPorStatus("concluida");
        service.remover("estudar Java");
    }
}