package documin.documento;

import java.util.ArrayList;

import documin.elementos.*;

public class Documento {
    private String titulo;
    private ArrayList<Elemento> elementos;
    private int tamanho;
    

    public Documento(String titulo) {
        this.titulo = titulo;
        this.elementos = new ArrayList<Elemento>();
    }

    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.elementos = new ArrayList<Elemento>();
        this.tamanho = tamanho;
    }

    public int getNumElementos() {
        return this.elementos.size();
    }

    public String[] exibirDocumento() {
        String[] out = new String[this.elementos.size()];

        for (int i = 0; i < out.length; i++) {
            out[i] = this.elementos.get(i).getRepresentacaoCompleta();
        }
        return out;
    }
}
