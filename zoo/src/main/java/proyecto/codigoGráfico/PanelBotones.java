package proyecto.codigoGráfico;

import javax.swing.*;

import proyecto.codigoGráfico.DialogosDeListas.DialogoListaAlimentar;
import proyecto.codigoGráfico.DialogosDeListas.DialogoListaDeAnimales;
import proyecto.codigoGráfico.DialogosDeListas.DialogoListaDeHabitats;
import proyecto.codigoInterno.Zoologico;

import java.awt.*;

/**
 * Panel de los botones principales del zoologico
 * @author Ariel Cisternas
 */
public class PanelBotones extends JPanel {
    /**
     * Constructor donde se determinan los botones, el tamaño y su posicion, ademas de las funcionalidades de los botones
     * @param ventana actual
     */
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
            DialogoListaDeHabitats lista = new DialogoListaDeHabitats(ventana); //se abre la lista de los habitats
            lista.setVisible(true);
        });
        botonAnimales.addActionListener(e -> {
            if (Zoologico.getInstance().getHabitats().size() == 0) {
                JOptionPane.showMessageDialog(this,"Aun no hay ningun hábitat creado");
            }
            else{
            DialogoListaDeAnimales lista = new DialogoListaDeAnimales(ventana); //se abre la lista de animales
            lista.setVisible(true);
            }
        });
        botonAlimentar.addActionListener(e -> {                                 //se el listado de animales a alimentar
            if (Zoologico.getInstance().getHabitats().size() == 0) {    
                JOptionPane.showMessageDialog(this,"Aun no hay ningun hábitat creado");
            }
            else{
            DialogoListaAlimentar lista = new DialogoListaAlimentar(ventana);
            lista.setVisible(true);
            }
        });
    }
}
