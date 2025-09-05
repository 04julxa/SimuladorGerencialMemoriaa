public class Processo {
    private String id;
    private int tamanhoKB;
    private int quantidadeDeBlocos;

    public Processo(String id, int tamanhoKB) {
        this.id = id;
        this.tamanhoKB = tamanhoKB;
        this.quantidadeDeBlocos = (int) Math.ceil(tamanhoKB / 2.0);

    }

    public String getId() {return id;}
    public int getQuantidadeDeBlocos() {return quantidadeDeBlocos;}
    public int getTamanhoKB() {return tamanhoKB;}


}
