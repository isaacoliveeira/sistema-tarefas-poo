package tarefas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Dados {
    public static void salvarTarefasEmCSV(List<Tarefa> tarefas, String arquivoCSV) {
        try (FileWriter writer = new FileWriter(arquivoCSV)) {
            writer.write("Titulo,Descricao,Prazo,Prioridade,Status\n");
            for (Tarefa tarefa : tarefas) {
                String linha = String.format("%s,%s,%s,%s,%s\n",
                        tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getPrazo(), tarefa.getPrioridade(), tarefa.getStatus());
                writer.write(linha);
            }
            System.out.println("Tarefas salvas com sucesso em " + arquivoCSV);
        } catch (IOException e) {
            System.err.println("Erro ao salvar as tarefas em " + arquivoCSV);
        }
    }
} 