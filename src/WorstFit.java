public class WorstFit implements Algoritmos {
    @Override
    public boolean alocar(Memoria memoria, Processo processo) {
        String[] blocos = memoria.getBlocos();
        int tamanhoNecessario = processo.getQuantidadeDeBlocos();

        int maiorInicio = -1;
        int maiorTamanho = 0;
        int inicioAtual = -1;
        int tamanhoAtual = 0;

        for (int i = 0; i < blocos.length; i++) {
            if (blocos[i] == null) {
                if (tamanhoAtual == 0) {
                    inicioAtual = i;
                }
                tamanhoAtual++;

                if (i == blocos.length - 1) {
                    if (tamanhoAtual > maiorTamanho) {
                        maiorTamanho = tamanhoAtual;
                        maiorInicio = inicioAtual;
                    }
                }
            } else {
                if (tamanhoAtual > maiorTamanho) {
                    maiorTamanho = tamanhoAtual;
                    maiorInicio = inicioAtual;
                }
                tamanhoAtual = 0;
            }
        }
        if (maiorTamanho >= tamanhoNecessario) {
            for (int j = maiorInicio; j < maiorInicio + tamanhoNecessario; j++) {
                blocos[j] = processo.getId();
            }
            return true;
        }

        return false;
    }
}
