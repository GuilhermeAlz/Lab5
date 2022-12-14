package documin.elementos;

public class TextoElement implements Elemento {
    private String valor;
    private int prioridade;

    public TextoElement(String valor, int prioridade) {
        this.valor = valor;
        this.prioridade = prioridade;
    }

    @Override
    public String getRepresentacaoResumida() {
        return this.valor;
    }

    @Override
    public String getRepresentacaoCompleta() {
        return this.valor;
    }

    @Override
    public int getPrioridade() {
        return this.prioridade;
    }
}
