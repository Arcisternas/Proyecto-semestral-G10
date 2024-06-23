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
        PanelHabitat panelHabitat = PanelHabitat.getInstance();
        PanelBotones panelBotones = new PanelBotones(ventana);
        zoo.setHabitatActual(zoo.getHabitatActual()); //En caso de que se inicialice en zoo con un hábitat ya existente
        panelHabitat.actualizarimagen();
        add(panelHabitat, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}
