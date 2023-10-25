package teste;
import java.io.*;
import java.util.Scanner;

public class teste {

    public static void main(String[] args) throws IOException {
    
    
        Scanner ler = new Scanner(System.in);
        String n;
    
        System.out.printf("Informe uma tarefa\n");
        n = ler.nextLine();
    
        BufferedWriter arq = new BufferedWriter(new FileWriter("tabuada.csv"));
        PrintWriter adicionaTarefa = new PrintWriter(arq);
    
          adicionaTarefa.println(n);
    
        arq.close();
    
        System.out.printf("\nTarefa adicionada com sucesso \"d:\\tabuada.txt\".\n", n);
      }
}