package documin.elementos;

import java.text.Collator;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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
        String[] palavras = this.valor.split(this.separador);
        for (int i = 0; i < palavras.length; i++) {
            palavras[i] = palavras[i].strip();
        }

        if (this.ordem.equals("nenhum")) {
            return this.valor;
        } else if (this.ordem.equals("tamanho")) {
            String[] palavrasAlf = tamanho(palavras);

            String out = "";
            for (int i = 0; i < palavrasAlf.length; i++) {
                if (i != palavrasAlf.length - 1) {
                    out += palavrasAlf[i] + " / ";
                } else {
                    out += palavrasAlf[i];
                }
            }

            return out;
        } else if (this.ordem.equals("alfabetica")) {
            Arrays.sort(palavras, Collator.getInstance());

            String out = "";
            for (int i = 0; i < palavras.length; i++) {
                if (i != palavras.length - 1) {
                    out += palavras[i] + " / ";
                } else {
                    out += palavras[i];
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

    private static String[] tamanho(String[] palavras) {
        for (int i = 0; i < palavras.length; i++) {
            int keyLoop = palavras[i].length();
            String key = palavras[i];
            int j = i - 1;

            while (j >= 0 && palavras[j].length() < keyLoop) {
                palavras[j + 1] = palavras[j];
                j = j - 1;
            }
            palavras[j + 1] = key;
        }
        return palavras;
    }
}
