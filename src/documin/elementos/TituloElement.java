package documin.elementos;

public class TituloElement implements Elemento {
    private String valor;
    private int prioridade;
    private int nivel;
    private boolean linkavel;

    public TituloElement(String valor, int prioridade, int nivel, boolean linkavel) {
        this.valor = valor;
        this.prioridade = prioridade;
        this.nivel = nivel;
        this.linkavel = linkavel;
    }

    @Override
    public String getRepresentacaoResumida() {
        return this.nivel + ". " + this.valor;
    }

    @Override
    public String getRepresentacaoCompleta() {
        if (linkavel) {
            return this.nivel + ". " + this.valor + " -- " + this.nivel + "-" + this.valor.toUpperCase().replaceAll("\s", "");
        } else {
            return this.nivel + ". " + this.valor;
        }
    }

    @Override
    public int getPrioridade() {
        return this.prioridade;
    }
}
