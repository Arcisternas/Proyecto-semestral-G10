package proyecto.codigoGráfico.DialogosDeEleccion;

import javax.swing.*;

import proyecto.codigoInterno.Zoologico;

import java.awt.*;

public class DialogoEleccionTipoAnimal extends JDialog {
    public DialogoEleccionTipoAnimal(JFrame ventana) {
        super(ventana, "Elija la especie del animal", true);
        setLayout(new GridLayout(1, 4));
        setSize(400, 100);
        setLocationRelativeTo(ventana);
        for (String tipo : Zoologico.getInstance().getHabitatActual().animalesPermitidos()) {
            JButton boton = new JButton(tipo);
            boton.addActionListener(e -> abirDialogo(ventana, tipo));
            add(boton);
        }
    }
    private void abirDialogo(JFrame ventana, String tipo){
        DialogoEleccionNombreAnimal elegir = new DialogoEleccionNombreAnimal(ventana,this,tipo);
        elegir.setVisible(true);
    }
}
