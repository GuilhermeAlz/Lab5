package documin;

import java.util.ArrayList;

import javax.annotation.processing.SupportedOptions;

import documin.documento.*;
import documin.elementos.*;

public class Main {
    public static void main(String[] args) {
        Elemento elemento = new TermosElement("Teste / termos / Aleatórios ", 1, "/", "tamanho");

        //System.out.println(elemento.getRepresentacaoCompleta());
        System.out.println(elemento.getRepresentacaoResumida());
    }
}
