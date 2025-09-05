import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("SIMULADOR DE GERENCIAMENTO DE MEMORIA");
        System.out.println("Escolha o algoritmo:");
        System.out.println("1 - First Fit");
        System.out.println("2 - Worst Fit");
        System.out.println("3 - Best Fit");
        System.out.print("Digite sua opcao: ");

        int opcao = scanner.nextInt();
        Algoritmos algoritmo = null;

        switch (opcao) {
            case 1:
                algoritmo = new FirstFit();
                System.out.println("\nALGORITMO SELECIONADO: FIRST FIT");
                break;
            case 2:
                algoritmo = new WorstFit();
                System.out.println("\nALGORITMO SELECIONADO: WORST FIT");
                break;
            default:
                System.out.println("Opcao invalida! Usando First Fit como padrao.");
                algoritmo = new FirstFit();
        }

        Memoria memoria = new Memoria();
        Processo p1 = new Processo("P1", 5);
        Processo p2 = new Processo("P2", 10);
        Processo p3 = new Processo("P3", 3);
        Processo p4 = new Processo("P4", 8);

        System.out.println("PROCESSOS CRIADOS:");
        System.out.println("- " + p1.getId() + ": " + p1.getQuantidadeDeBlocos() + " blocos");
        System.out.println("- " + p2.getId() + ": " + p2.getQuantidadeDeBlocos() + " blocos");
        System.out.println("- " + p3.getId() + ": " + p3.getQuantidadeDeBlocos() + " blocos");
        System.out.println("- " + p4.getId() + ": " + p4.getQuantidadeDeBlocos() + " blocos");
        System.out.println();

        System.out.println("FASE 1 - ALOCACAO INICIAL");
        System.out.println("--------------------------");

        System.out.println("Alocando P1 (" + p1.getQuantidadeDeBlocos() + " blocos):");
        boolean success1 = algoritmo.alocar(memoria, p1);
        System.out.println("Alocado: " + success1);
        memoria.mostrar();

        System.out.println("Alocando P2 (" + p2.getQuantidadeDeBlocos() + " blocos):");
        boolean success2 = algoritmo.alocar(memoria, p2);
        System.out.println("Alocado: " + success2);
        memoria.mostrar();

        System.out.println("Alocando P3 (" + p3.getQuantidadeDeBlocos() + " blocos):");
        boolean success3 = algoritmo.alocar(memoria, p3);
        System.out.println("Alocado: " + success3);
        memoria.mostrar();

        System.out.println("FASE 2 - LIBERACAO E REALOCACAO");
        System.out.println("-------------------------------");

        System.out.println("Liberando processo P2:");
        memoria.liberar("P2");
        memoria.mostrar();

        System.out.println("Alocando P4 (" + p4.getQuantidadeDeBlocos() + " blocos):");
        boolean success4 = algoritmo.alocar(memoria, p4);
        System.out.println("Alocado: " + success4);
        memoria.mostrar();


    }
}