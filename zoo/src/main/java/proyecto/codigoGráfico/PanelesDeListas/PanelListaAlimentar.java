package proyecto.codigoGráfico.PanelesDeListas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import proyecto.codigoInterno.Animales.*;

/**
 * Panel de la lista para alimentar
 * @author Ariel Cisternas
 * @author Maria Jesus Olivares
 */

public class PanelListaAlimentar extends JPanel {
    private JLabel etiquetaHabitat; //habitat actual
    private String texto;   //texto de los animales
    private JButton alimentar;  //boton de alimentar individualmente

    /**
     * Constructor del panel de la lista que se genera de uno de los 3 principales botones del zoologico
     * @param animal animales en el habitat
     * @param listener escucha del boton
     */
    public PanelListaAlimentar(Animal animal, ActionListener listener) {
        setLayout(new BorderLayout());
        texto = animal.getNombre()+" ("+animal.getEspecie()+")  " + "  Animo: " + animal.getAnimo();
        etiquetaHabitat = new JLabel(texto);
        alimentar = new JButton("Alimentar");
        alimentar.addActionListener(listener);
        add(alimentar, BorderLayout.EAST);
        add(etiquetaHabitat, BorderLayout.CENTER);
    }
}