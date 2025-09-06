public class AlgoritmoFactory {
    public static Algoritmos criarAlgoritmo(Memoria memoria) {
        EstrategiaAdaptativa estrategia = new EstrategiaAdaptativa();
        String tipo = estrategia.escolherAlgoritmo(memoria);

        System.out.println("Ocupação atual: " + calcularOcupacao(memoria) + "%");
        System.out.println("Algoritmo escolhido: " + tipo);

        switch (tipo) {
            case "firstfit":
                return new FirstFit();
            case "worstfit":
                return new WorstFit();
            case "bestfit":
                return new BestFit();
            default:
                return new FirstFit();
        }
    }

    private static double calcularOcupacao(Memoria memoria) {
        int usados = 0;
        String[] blocos = memoria.getBlocos();

        for (String bloco : blocos) {
            if (bloco != null) usados++;
        }

        return (usados * 100.0) / blocos.length;
    }
}