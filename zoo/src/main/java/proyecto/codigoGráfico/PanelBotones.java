package proyecto.codigoGráfico;

import javax.swing.*;
import java.awt.*;

public class PanelBotones extends JPanel {
    public PanelBotones(Ventana ventana) {
        super();
        setLayout(new GridLayout(1, 3));
        JButton botonLista = new JButton("Lista de Habitats");
        JButton boton2 = new JButton("Lista de Animales");
        JButton boton3 = new JButton("Alimentar");
        add(botonLista);
        add(boton2);
        add(boton3);
        botonLista.addActionListener(e -> {
            DialogoListaDeHabitats lista = new DialogoListaDeHabitats(ventana);
            lista.setVisible(true);
        });
    }
}
