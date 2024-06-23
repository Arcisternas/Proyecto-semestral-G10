package proyecto.codigoGráfico;

import javax.swing.*;

import proyecto.codigoGráfico.DialogosDeListas.DialogoListaDeAnimales;
import proyecto.codigoGráfico.DialogosDeListas.DialogoListaDeHabitats;

import java.awt.*;

public class PanelBotones extends JPanel {
    public PanelBotones(Ventana ventana) {
        super();
        setLayout(new GridLayout(1, 3));
        JButton botonHabitats = new JButton("Lista de Habitats");
        JButton botonAnimales = new JButton("Lista de Animales");
        JButton boton3 = new JButton("Alimentar");
        add(botonHabitats);
        add(botonAnimales);
        add(boton3);
        botonHabitats.addActionListener(e -> {
            DialogoListaDeHabitats lista = new DialogoListaDeHabitats(ventana);
            lista.setVisible(true);
        });
        botonAnimales.addActionListener(e -> {
            DialogoListaDeAnimales lista = new DialogoListaDeAnimales(ventana);
            lista.setVisible(true);
        });
    }
}
