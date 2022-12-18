package documin.documento;

public class Visao {
    private String[] visao;

    public Visao(int tamanho) {
        this.visao = new String[tamanho];
    }

    public String[] getVisao() {
        return this.visao;
    }

    public void addVisao(String[] rep) {
        this.visao = rep;
    }
}
