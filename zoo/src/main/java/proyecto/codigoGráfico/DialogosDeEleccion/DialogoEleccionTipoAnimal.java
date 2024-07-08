package proyecto.codigoGráfico.DialogosDeEleccion;

import javax.swing.*;

import proyecto.codigoInterno.Zoologico;

import java.awt.*;

/**
 * Clase de seleccion de tipo de animal
 * @author Ariel Cisternas
 */

public class DialogoEleccionTipoAnimal extends JDialog {
    /**
     * Constructor, donde segun el tipo de habitat actual, se pueden escoger ciertos animales permitidos
     * @param ventana acutal
     */
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
    /**
     * metodo donde se dispone a abrir el dialogo para darle un nombre al animal
     * @param ventana actual
     * @param tipo de animal
     */
    private void abirDialogo(JFrame ventana, String tipo){
        DialogoEleccionNombreAnimal elegir = new DialogoEleccionNombreAnimal(ventana,this,tipo);
        elegir.setVisible(true);
    }
}
