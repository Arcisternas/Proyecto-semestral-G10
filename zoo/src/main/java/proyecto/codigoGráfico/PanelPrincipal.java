package proyecto.codigoGráfico;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel{
    public PanelPrincipal(Ventana ventana){
        super();
        setLayout(new BorderLayout());
        PanelIntro panelIntro = new PanelIntro();
        PanelBotones panelBotones = new PanelBotones(ventana);
        //PanelHabitat panelHabitat = new PanelHabitat();
        add(panelIntro, BorderLayout.CENTER);
        //add(panelHabitat, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}
