package documin;

import java.util.ArrayList;

import javax.annotation.processing.SupportedOptions;

import documin.documento.*;
import documin.elementos.*;

public class Main {
    public static void main(String[] args) {
        Elemento elemento = new TermosElement("teste / aberto / casa / bullying / termos", 1, "/", "Alfabética");

        //System.out.println(elemento.getRepresentacaoCompleta());
        System.out.println(elemento.getRepresentacaoResumida());
    }
}
