package proyecto.codigoGráfico;

import javax.swing.*;

public class Ventana extends JFrame {

    public Ventana() {
        super();
        setSize(1000, 900); //Tamaño de los habitat: 5000x4500 (Adaptado(:5): 1000x900)
        setTitle("Zoológico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        PanelPrincipal panelPrincipal = new PanelPrincipal(this);
        add(panelPrincipal);

        
        setVisible(true);
    }
}
