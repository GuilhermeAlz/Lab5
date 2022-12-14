package documin.elementos;

import java.util.Arrays;
import java.util.HashMap;

public class ListaElement implements Elemento {
    private String valor;
    private int prioridade;
    private String separador;
    private String charLista;

    public ListaElement(String valor, int prioridade, String separador, String charLista) {
        this.valor = valor;
        this.prioridade = prioridade;
        this.separador = separador;
        this.charLista = charLista;
    }

    @Override
    public String getRepresentacaoResumida() {
        return this.valor.replaceAll(" " + this.separador, ",");
    }

    @Override
    public String getRepresentacaoCompleta() {
        String[] palavras = this.valor.split(this.separador);
        String out = "";

        for (String palavra : palavras) {
            out += this.charLista + " " + palavra.strip() + "\n"; 
        }

        return out;
    }

    @Override
    public int getPrioridade() {
        return this.prioridade;
    }
}
