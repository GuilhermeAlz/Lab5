package documin.documento;

import java.util.ArrayList;

import documin.elementos.*;

public class Documento {
    private String titulo;
    private ArrayList<Elemento> elementos;
    private int tamanho;
    private boolean ehAtalho;
    

    public Documento(String titulo) {
        this.titulo = titulo;
        this.elementos = new ArrayList<Elemento>();
        this.ehAtalho = false;
    }

    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.elementos = new ArrayList<Elemento>();
        this.tamanho = tamanho;
        this.ehAtalho = false;
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
        if (this.elementos.size() < this.tamanho) {
            this.elementos.add(new TextoElement(valor, prioridade));
            return this.elementos.size() - 1;
        } else {
            throw new IllegalArgumentException("Tamanho excedido");
        }
    }

    public int criarTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
        if (this.elementos.size() < this.tamanho) {
            this.elementos.add(new TituloElement(valor, prioridade, nivel, linkavel));
            return this.elementos.size() - 1;
        } else {
            throw new IllegalArgumentException("Tamanho excedido");
        }
    }

    public int criarLista(String valor, int prioridade, String separador, String charLista) {
        if (this.elementos.size() < this.tamanho) {
            this.elementos.add(new ListaElement(valor, prioridade, separador, charLista));
            return this.elementos.size() - 1;
        } else {
            throw new IllegalArgumentException("Tamanho excedido");
        }
    }

    public int criarTermos(String valor, int prioridade, String separador, String ordem) {
        if (this.elementos.size() < this.tamanho) {
            this.elementos.add(new TermosElement(valor, prioridade, separador, ordem));
            return this.elementos.size() - 1;
        } else {
            throw new IllegalArgumentException();
        }
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

    public String getNome() {
        return this.titulo;
    }

    public int getMediaPrioridade() {
        int total = 0;
        int numElementos = 0;

        for (Elemento elm : this.elementos) {
            total += elm.getPrioridade();
            numElementos += 1;
        }

        total = total / numElementos;
        return total;
    }

    public String getRepCompAtalho() {
        String out = "";

        for (Elemento elm : this.elementos) {
            if (elm.getPrioridade() == 4 || elm.getPrioridade() == 5) {
                out += elm.getRepresentacaoCompleta();
            }
        }

        return out;
    }

    public String getRepResAtalho() {
        String out = "";

        for (Elemento elm : this.elementos) {
            if (elm.getPrioridade() == 4 || elm.getPrioridade() == 5) {
                out += elm.getRepresentacaoResumida();
            }
        }

        return out;
    }

    public int criaAtalho(Documento doc) {
        this.elementos.add(new AtalhoElement(doc));

        return this.elementos.size() - 1;
    }

    public ArrayList<Elemento> getElementos() {
        return this.elementos;
    }

    public boolean getEhAtalho() {
        return this.ehAtalho;
    }

    public void atualizaEhAtalho(boolean boo) {
        this.ehAtalho = boo;
    }

    public Elemento getElemento(int posicao) {
        return this.elementos.get(posicao);
    }
}
