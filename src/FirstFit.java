public class FirstFit implements Algoritmos {
    @Override

    public boolean alocar(Memoria memoria, Processo processo) {
        String[] blocos = memoria.getBlocos();
        int livresEmSeguida = 0;
        int inicio = -1;

        for (int i = 0; i <blocos.length; i++) {
          if (blocos[i] == null) {
              if (livresEmSeguida == 0) inicio = i;
              livresEmSeguida++;
              if(livresEmSeguida == processo.getQuantidadeDeBlocos()) {
                  for (int j = inicio; j < inicio + processo.getQuantidadeDeBlocos(); j++) {
                      blocos[j] = processo.getId();
                  }
                  return true;
              }
          }  else {
              livresEmSeguida = 0;
          }
        }
        return false;
    }

}
