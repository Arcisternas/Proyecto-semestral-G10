package proyecto.codigoGráfico;

import javax.swing.*;

import proyecto.codigoGráfico.DialogosDeListas.DialogoListaAlimentar;
import proyecto.codigoGráfico.DialogosDeListas.DialogoListaDeAnimales;
import proyecto.codigoGráfico.DialogosDeListas.DialogoListaDeHabitats;

import java.awt.*;

public class PanelBotones extends JPanel {
    public PanelBotones(Ventana ventana) {
        super();
        setLayout(new GridLayout(1, 3));
        setSize(1000,25);
        JButton botonHabitats = new JButton("Lista de Habitats");
        JButton botonAnimales = new JButton("Lista de Animales");
        JButton botonAlimentar = new JButton("Alimentar");
        add(botonHabitats);
        add(botonAnimales);
        add(botonAlimentar);
        botonHabitats.addActionListener(e -> {
            DialogoListaDeHabitats lista = new DialogoListaDeHabitats(ventana);
            lista.setVisible(true);
        });
        botonAnimales.addActionListener(e -> {
            DialogoListaDeAnimales lista = new DialogoListaDeAnimales(ventana);
            lista.setVisible(true);
        });
        botonAlimentar.addActionListener(e -> {
            DialogoListaAlimentar lista = new DialogoListaAlimentar(ventana);
            lista.setVisible(true);
        });
    }
}
