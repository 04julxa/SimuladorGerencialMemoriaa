import java.util.Arrays;

public class Memoria {
    private String[] blocos;

    public Memoria() {
        this.blocos = new String[64];
        Arrays.fill(blocos, null);
    }

    public String[] getBlocos() {
        return blocos;
    }

    public void liberar(String processoId) {
        for (int i = 0; i < blocos.length; i++) {
            if (processoId.equals(blocos[i])) {
                blocos[i] = null;
            }
        }
    }

    public void mostrar() {
        System.out.println("=== Estado da Memoria ===");
        int usados = 0;

        for (int i = 0; i < blocos.length; i++) {
            String valor = (blocos[i] == null) ? "  " : blocos[i];
            if (blocos[i] != null) usados++;

            System.out.printf("[%s]", valor);

            // Quebra de linha a cada 16 blocos (formato 4x16)
            if ((i + 1) % 16 == 0) {
                System.out.println();
            }
        }

        int livres = blocos.length - usados;
        double percentual = (usados * 100.0) / blocos.length;

        System.out.println("=========================");
        System.out.printf("Blocos usados: %d | Blocos livres: %d | Ocupacao: %.2f%%\n\n",
                usados, livres, percentual);
    }}