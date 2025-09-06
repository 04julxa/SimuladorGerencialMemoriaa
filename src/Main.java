import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("SIMULADOR ADAPTATIVO DE GERENCIAMENTO DE MEMORIA");
        System.out.println("Processos com tamanhos aleatorios entre 2KB e 32KB");


        Memoria memoria = new Memoria();

        Processo[] processos = new Processo[10];
        for (int i = 0; i < processos.length; i++) {
            int tamanhoKB = 2 + random.nextInt(31);
            processos[i] = new Processo("P" + (i + 1), tamanhoKB);
        }

        System.out.println("PROCESSOS CRIADOS ALEATORIAMENTE:");
        for (Processo p : processos) {
            System.out.println("- " + p.getId() + ": " + p.getTamanhoKB() +
                    "KB (" + p.getQuantidadeDeBlocos() + " blocos)");
        }
        System.out.println();

        for (Processo processo : processos) {
            System.out.println("\n--- Alocando " + processo.getId() + " (" +
                    processo.getTamanhoKB() + "KB = " + processo.getQuantidadeDeBlocos() + " blocos) ---");

            Algoritmos algoritmo = AlgoritmoFactory.criarAlgoritmo(memoria);

            boolean sucesso = algoritmo.alocar(memoria, processo);

            if (sucesso) {
                System.out.println("SUCESSO: " + processo.getId() + " alocado com sucesso!");
            } else {
                System.out.println("FALHA: Nao foi possivel alocar " + processo.getId());
                System.out.println("Liberando processo aleatorio...");


                liberarProcessoAleatorio(memoria, processos);
                System.out.println("Tentando alocar novamente...");


                sucesso = new FirstFit().alocar(memoria, processo);
                if (sucesso) {
                    System.out.println("SUCESSO: " + processo.getId() + " alocado apos liberacao!");
                } else {
                    System.out.println("FALHA DEFINITIVA: Nao foi possivel alocar " + processo.getId());
                }
            }

            memoria.exibir();

            try { Thread.sleep(1500); } catch (InterruptedException e) {}
        }

        System.out.println("\nSIMULACAO CONCLUIDA!");
    }

    private static void liberarProcessoAleatorio(Memoria memoria, Processo[] processos) {
        Random random = new Random();
        String[] blocos = memoria.getBlocos();


        java.util.List<String> processosAtivos = new java.util.ArrayList<>();
        for (String bloco : blocos) {
            if (bloco != null && !bloco.isEmpty() && !processosAtivos.contains(bloco)) {
                processosAtivos.add(bloco);
            }
        }

        if (!processosAtivos.isEmpty()) {
            String processoLiberar = processosAtivos.get(random.nextInt(processosAtivos.size()));
            memoria.liberar(processoLiberar);
            System.out.println("Processo " + processoLiberar + " liberado!");
        } else {
            System.out.println("Nenhum processo para liberar");
        }
    }
}
