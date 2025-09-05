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
        System.out.println("Estado da Memória:");
        for (int i = 0; i < blocos.length; i++) {
            System.out.print(blocos[i] == null ? "" : blocos[i]);
            if ((i + 1) % 16 == 0) System.out.println();
        }
        System.out.println();
    }
}
