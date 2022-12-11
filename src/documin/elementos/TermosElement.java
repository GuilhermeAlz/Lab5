package documin.elementos;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        String[] palavrasSep = this.valor.split(this.separador);
        List<String> palavras = Arrays.asList(palavrasSep);
        for (String palavra : palavras) {
            palavra = palavra.strip();
        }

        if (this.ordem.equals("nenhum")) {
            return this.valor;
        } else if (this.ordem.equals("tamanho")) {
            return this.valor;
        } else if (this.ordem.equals("alfabetica")) {
            Collections.sort(palavras);

            String out = "";
            for (int i = 0; i < palavras.size(); i++) {
                if (i != palavras.size() - 1) {
                    out += palavras.get(i) + " / ";
                } else {
                    out += palavras.get(i);
                }
            }

            return out;
        } else {
            throw new IllegalArgumentException("Ordem invalida");
        }
    }

    @Override
    public String getRepresentacaoCompleta() {
        return null;
    }

    private static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
