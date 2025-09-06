public class BestFit implements Algoritmos {
    @Override
    public boolean alocar(Memoria memoria, Processo processo) {
        String[] blocos = memoria.getBlocos();
        int tamanhoNecessario = processo.getQuantidadeDeBlocos();

        int melhorInicio = -1;
        int melhorTamanho = Integer.MAX_VALUE;

        int inicioAtual = -1;
        int tamanhoAtual = 0;

        for (int i = 0; i < blocos.length; i++) {
           
            if (blocos[i] == null) {
                
                if (tamanhoAtual == 0) {
                    inicioAtual = i;
                }
            
                tamanhoAtual++;

                if (i == blocos.length - 1) {
         
                    if (tamanhoAtual >= tamanhoNecessario && tamanhoAtual < melhorTamanho) {
                        melhorTamanho = tamanhoAtual;
                        melhorInicio = inicioAtual;
                    }
                }
            } else { 
                if (tamanhoAtual >= tamanhoNecessario && tamanhoAtual < melhorTamanho) {
                    melhorTamanho = tamanhoAtual;
                    melhorInicio = inicioAtual;
                }
       
                tamanhoAtual = 0;
            }
        }
 
        if (melhorInicio != -1) {
         
            for (int j = melhorInicio; j < melhorInicio + tamanhoNecessario; j++) {
                blocos[j] = processo.getId();
            }
            return true;
        }

        return false;
    }
}