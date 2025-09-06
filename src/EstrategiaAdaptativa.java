public class EstrategiaAdaptativa {
    public String escolherAlgoritmo(Memoria memoria) {
        double ocupacao = calcularOcupacao(memoria);
        System.out.printf("Ocupacao atual: %.2f%% - ", ocupacao);

        if (ocupacao < 40) {
            System.out.println("Usando FirstFit (baixa ocupacao)");
            return "firstfit";
        } else if (ocupacao < 75) {
            System.out.println("Usando BestFit (media ocupacao)");
            return "bestfit";
        } else {
            System.out.println("Usando WorstFit (alta ocupacao)");
            return "worstfit";
        }
    }

    private double calcularOcupacao(Memoria memoria) {
        int usados = 0;
        String[] blocos = memoria.getBlocos();

        for (String bloco : blocos) {
            if (bloco != null) usados++;
        }

        return (usados * 100.0) / blocos.length;
    }
}
