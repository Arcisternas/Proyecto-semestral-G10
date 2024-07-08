package proyecto.codigoGráfico;

import javax.swing.*;

/**
 * Ventana principal del Zoologico
 * @author Ariel Cisternas
 */

public class Ventana extends JFrame {

    public Ventana() {
        super();
        setSize(1000, 925);
        setResizable(false);
        setTitle("Zoológico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        PanelPrincipal panelPrincipal = new PanelPrincipal(this);
        add(panelPrincipal);
        this.pack();
        
        setVisible(true);
    }
}
