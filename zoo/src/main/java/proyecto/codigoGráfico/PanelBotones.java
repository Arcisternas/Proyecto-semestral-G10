package proyecto.codigoGráfico;

import javax.swing.*;
import java.awt.*;

public class PanelBotones extends JPanel {
    public PanelBotones() {
        super();
        setLayout(new GridLayout(1, 3));
        JButton boton1 = new JButton("Lista de Habitats");
        JButton boton2 = new JButton("Añadir Animal");
        JButton boton3 = new JButton("Alimentar");
        add(boton1);
        add(boton2);
        add(boton3);
    }
}
