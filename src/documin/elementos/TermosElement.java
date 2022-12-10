package documin.elementos;

import java.text.Normalizer;
import java.util.Arrays;

public class TermosElement implements Elemento {
    private String valor;
    private int prioridade;
    private String separador;
    private String ordem;

    public TermosElement(String valor, int prioridade, String separador, String ordem) {
        this.valor = valor;
        this.prioridade = prioridade;
        this.separador = separador;
        this.ordem = removerAcentos(ordem.toLowerCase());
    }

    @Override
    public String getRepresentacaoResumida() {
        return null;
    }

    @Override
    public String getRepresentacaoCompleta() {
        // TODO Auto-generated method stub
        return null;
    }

    private static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
