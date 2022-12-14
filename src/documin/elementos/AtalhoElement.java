package documin.elementos;

import documin.documento.*;

public class AtalhoElement implements Elemento {
    private int prioridade;
    private String valor;
    private String representacaoCompleta;
    private String representacaoResumida;

    public AtalhoElement(Documento doc) {
        
        
        this.prioridade = doc.getMediaPrioridade();
        this.valor = doc.getNome();
        this.representacaoCompleta = doc.getRepCompAtalho();
        this.representacaoResumida = doc.getRepResAtalho();
    }

    @Override
    public String getRepresentacaoResumida() {
        return this.representacaoResumida;
    }

    @Override
    public String getRepresentacaoCompleta() {
        return this.representacaoCompleta;
    }

    @Override
    public int getPrioridade() {
        return this.prioridade;
    }
    
}
