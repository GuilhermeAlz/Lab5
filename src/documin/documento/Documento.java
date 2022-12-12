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

    public int criarTexto(String valor, int prioridade) {
        this.elementos.add(new TextoElement(valor, prioridade));
        
        return this.elementos.size() - 1;
    }

    public int criarTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
        this.elementos.add(new TituloElement(valor, prioridade, nivel, linkavel));

        return this.elementos.size() - 1;
    }

    public int criarLista(String valor, int prioridade, String separador, String charLista) {
        this.elementos.add(new ListaElement(valor, prioridade, separador, charLista));

        return this.elementos.size() - 1;
    }

    public int criarTermos(String valor, int prioridade, String separador, String ordem) {
        this.elementos.add(new TermosElement(valor, prioridade, separador, ordem));

        return this.elementos.size() - 1;
    }

    public String pegarRepresentacaoCompleta(int elementoPosicao) {
        return this.elementos.get(elementoPosicao).getRepresentacaoCompleta();
    }

    public String pegarRepresentacaoResumida(int elementoPosicao) {
        return this.elementos.get(elementoPosicao).getRepresentacaoResumida();
    }

    public boolean apagarElemento(int elementoPosicao) {
        try {
            this.elementos.remove(elementoPosicao);
            return true; 
        } catch (Exception e) {
            return false;
        }
    }

    public void moverParaCima(int elementoPosicao) {
        Elemento temp = this.elementos.get(elementoPosicao);

        this.elementos.set(elementoPosicao, this.elementos.get(elementoPosicao - 1));
        this.elementos.set(elementoPosicao - 1, temp);
    }

    public void moverParaBaixo(int elementoPosicao) {
        Elemento temp = this.elementos.get(elementoPosicao);

        this.elementos.set(elementoPosicao, this.elementos.get(elementoPosicao + 1));
        this.elementos.set(elementoPosicao + 1, temp);
    }
}
