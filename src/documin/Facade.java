package documin;

import documin.documento.DocumentoController;

public class Facade {
    private DocumentoController dc;

    public Facade() {
        this.dc = new DocumentoController();
    }
    
    public boolean criarDocumento(String titulo) {
        return this.dc.criarDocumento(titulo);
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        return this.dc.criarDocumento(titulo, tamanhoMaximo);
    }

    public void removerDocumento(String titulo) {
        this.dc.removerDocumento(titulo);
    }

    public int contarElementos(String titulo) {
        return this.dc.contarElementos(titulo);
    }

    public String[] exibirDocumento(String titulo) {
        return this.dc.exibirDocumento(titulo);
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        return this.dc.criarTexto(tituloDoc, valor, prioridade);
    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        return this.dc.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
    }

    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        return this.dc.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
    }

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem){
        return this.dc.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
    }

    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return this.dc.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }

    public String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return this.dc.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return this.dc.apagarElemento(tituloDoc, elementoPosicao);
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        this.dc.moverParaCima(tituloDoc, elementoPosicao);
    }

    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        this.dc.moverParaBaixo(tituloDoc, elementoPosicao);
    }

    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        return this.dc.criarAtalho(tituloDoc, tituloDocReferenciado);
    }

    public int criarVisaoCompleta(String tituloDoc) {
        return dc.criarVisaoCompleta(tituloDoc);
    }

    public int criarVisaoResumida(String tituloDoc) {
        return dc.criarVisaoResumida(tituloDoc);
    }

    public int criarVisaoPrioritaria(String tituloDoc, int prioridade)  {
        return dc.criarVisaoPrioritaria(tituloDoc, prioridade);
    }

    public int criarVisaoTitulo(String tituloDoc) {
        return dc.criarVisaoTitulo(tituloDoc);
    }

    public String[] exibirVisao(int visaoId) {
        return dc.exibirVisao(visaoId);
    }
}
