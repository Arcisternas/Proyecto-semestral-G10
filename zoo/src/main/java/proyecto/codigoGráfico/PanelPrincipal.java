package proyecto.codigoGráfico;

import javax.swing.*;
import java.awt.*;

import proyecto.codigoInterno.*;
/**
 * Panel principal donde se visualizan botones e imagenes
 * @author Ariel Cisternas
 */

public class PanelPrincipal extends JPanel{
    private Zoologico zoo;
    /**
     * Constructor donde se añaden los botones e imagenes correspondientess
     * @param ventana principal
     */
    public PanelPrincipal(Ventana ventana){
        super();
        zoo = Zoologico.getInstance();
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1000,900));
        setBounds(0, 0, 1000, 900);
        PanelHabitat panelHabitat = PanelHabitat.getInstance();
        PanelBotones panelBotones = new PanelBotones(ventana);
        zoo.setHabitatActual(zoo.getHabitatActual()); //En caso de que se inicialice en zoo con un hábitat ya existente
        panelHabitat.actualizarImagenesPanel();
        add(panelHabitat, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}
