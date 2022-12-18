package documin.documento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class DocumentoController {
    private HashMap<String, Documento> documentos;
    private ArrayList<Visao> visoes;

    public DocumentoController() {
        this.documentos = new HashMap<String, Documento>();
        this.visoes = new ArrayList<Visao>();
    }

    public boolean criarDocumento(String titulo) {
        if (this.documentos.containsKey(titulo)) {
            return false;
        }
        if (titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo invalido");
        }

        this.documentos.put(titulo, new Documento(titulo));
        return true;
    }

    public boolean criarDocumento(String titulo, int tamanho) {
        if (this.documentos.containsKey(titulo)) {
            return false;
        }
        if (tamanho == 0 || tamanho < 0) {
            throw new IllegalArgumentException("Tamanho invalido");
        }
        if (titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo invalido");
        }

        this.documentos.put(titulo, new Documento(titulo, tamanho));
        return true;
    }

    public void removerDocumento(String titulo) {
        if (titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo invalido");
        }
        if (!this.documentos.containsKey(titulo)) {
            throw new NoSuchElementException("Documento nao cadastrado");
        }

        this.documentos.remove(titulo);
    }

    public int contarElementos(String titulo) {
        if (titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo invalido");
        }
        if (!this.documentos.containsKey(titulo)) {
            throw new NoSuchElementException("Documento nao cadastrado");
        }

        return this.documentos.get(titulo).getNumElementos();
    }

    public String[] exibirDocumento(String titulo) {
        if (titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo invalido");
        }
        if (!this.documentos.containsKey(titulo)) {
            throw new NoSuchElementException("Documento nao cadastrado");
        }

        return this.documentos.get(titulo).exibirDocumento();
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        return this.documentos.get(tituloDoc).criarTexto(valor, prioridade);
    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        return this.documentos.get(tituloDoc).criarTitulo(valor, prioridade, nivel, linkavel);
    }

    public int criarLista(String tituloDoc, String valor, int prioridade, String separador, String charLista) {
        return this.documentos.get(tituloDoc).criarLista(valor, prioridade, separador, charLista);
    }

    public int criarTermos(String tituloDoc, String valor, int prioridade, String separador, String ordem) {
        return this.documentos.get(tituloDoc).criarTermos(valor, prioridade, separador, ordem);
    }

    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return this.documentos.get(tituloDoc).pegarRepresentacaoCompleta(elementoPosicao);
    }

    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return this.documentos.get(tituloDoc).pegarRepresentacaoResumida(elementoPosicao);
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return this.documentos.get(tituloDoc).apagarElemento(elementoPosicao);
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        this.documentos.get(tituloDoc).moverParaCima(elementoPosicao);
    }

    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        this.documentos.get(tituloDoc).moverParaBaixo(elementoPosicao);
    }

    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        if (!this.documentos.get(tituloDoc).getEhAtalho()) {
            if (!this.documentos.get(tituloDocReferenciado).temAtalho()) {
                this.documentos.get(tituloDocReferenciado).atualizaEhAtalho(true);
                return this.documentos.get(tituloDoc).criaAtalho(this.documentos.get(tituloDocReferenciado));
            } else {
                throw new IllegalArgumentException("O documento referenciado tem atalhos, logo nao pode se tornar um atalho");
            }
        } else {
            throw new IllegalStateException("O documento já é um atalho, logo nao pode ter atalhos adicionados");
        }
    }

    public int criarVisaoCompleta(String tituloDoc) {
        Visao visao = new Visao(this.documentos.get(tituloDoc).getNumElementos());
        visao.addVisao(this.documentos.get(tituloDoc).getVisaoCompleta());
        this.visoes.add(visao);
        return this.visoes.size() - 1;
    }

    public int criarVisaoResumida(String tituloDoc) {
        Visao visao = new Visao(this.documentos.get(tituloDoc).getNumElementos());
        visao.addVisao(this.documentos.get(tituloDoc).getVisaoResumida());
        this.visoes.add(visao);
        return this.visoes.size() - 1;
    }
    
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        Visao visao = new Visao(this.documentos.get(tituloDoc).getNumElementos());
        visao.addVisao(this.documentos.get(tituloDoc).getVisaoPrioritaria(prioridade));
        this.visoes.add(visao);
        return this.visoes.size() - 1;
    }

    public int criarVisaoTitulo(String tituloDoc) {
        Visao visao = new Visao(this.documentos.get(tituloDoc).getNumElementos());
        visao.addVisao(this.documentos.get(tituloDoc).getVisaoTitulos());
        this.visoes.add(visao);
        return this.visoes.size() - 1;
    }

    public String[] exibirVisao(int visaoId) {
        return this.visoes.get(visaoId).getVisao();
    }
}
