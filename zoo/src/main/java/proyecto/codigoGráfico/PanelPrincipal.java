package proyecto.codigoGráfico;

import javax.swing.*;
import java.awt.*;

import proyecto.codigoInterno.*;

public class PanelPrincipal extends JPanel{
    private Zoologico zoo;
    public PanelPrincipal(Ventana ventana){
        super();
        zoo = Zoologico.getInstance();
        setLayout(new BorderLayout());
        PanelIntro panelIntro = new PanelIntro();
        PanelBotones panelBotones = new PanelBotones(ventana);
        if (zoo.getHabitats().size() == 0){
            add(panelIntro, BorderLayout.CENTER);
        }
        else{
            PanelHabitat panelHabitat = PanelHabitat.getInstance();
            add(panelHabitat, BorderLayout.CENTER);
        }
        add(panelBotones, BorderLayout.SOUTH);
    }
}
